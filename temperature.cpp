#include <iostream>
#include <algorithm>
#include <cmath>
#include <pthread.h>

#define WIDTH 60 //矩阵大小

using namespace std;

typedef struct Args{
    int begin;
    int step;
}Args;              //cal_temperature函数的参数类型

double InitMatrix[WIDTH][WIDTH], ResultMatrix[WIDTH][WIDTH];
bool stable_flag = false;//温度矩阵稳定的参数
void *cal_temperature(void *_args);


bool inSector(int i, int j){
    return pow((i - WIDTH / 2), 2) + 
    pow((j - WIDTH / 2), 2) - pow(WIDTH / 2, 2) <= 0;
}

int main (int argc, char *argv[])
{
    int np = atoi(argv[1]);
    if (np < 0 && np > WIDTH){
        return 0;
    }
    //1. 温度矩阵初始化
    for (int i = 0; i < WIDTH; ++ i) {
        for (int j = 0; j < WIDTH; ++ j) {
            InitMatrix[i][j] = ResultMatrix[i][j] = 0;
        }
    }
    InitMatrix[WIDTH / 2][WIDTH / 2] = ResultMatrix[WIDTH / 2][WIDTH / 2] = 60;
    Args *arg;
    pthread_t *pid;
    pid = (pthread_t *)malloc(np * sizeof(pthread_t));

    while (!stable_flag) {
        stable_flag = true;
        for (int i = 1; i <= np; ++i) {
            arg = (Args *)malloc(sizeof(Args));
            arg->begin = i;
            arg->step = np;
            pthread_create(&pid[i - 1], NULL, cal_temperature, (void *)arg);
        }               //创建线程
        for (int i = 0; i < np; i++) {
            pthread_join(pid[i], NULL);//主线程等待子线程
        }
    }

    /*for (int i = 1; i < (WIDTH - 1); ++i) {
        for (int j = 1; j < (WIDTH - 1); ++j) {
            InitMatrix[i][j] = ResultMatrix[i][j];
            cout << InitMatrix[i][j] << " ";
        }
        cout << endl;//输出稳定的温度矩阵
    }*/

    int counter = 0;
    for (int i = WIDTH / 2; i < WIDTH; ++i) {
        for (int j = WIDTH / 2; j < WIDTH; ++j) {
            //计算温度矩阵大于某温度阀值的点的个数
            //1/4圆：307
            //扇形：249
            if ((ResultMatrix[i][j] - 0.01) > pow(10.0, -3) && inSector(i, j)) {
                counter++;
            }
        }
    } 
    cout << "\tResult :" << counter << endl;//输出个数
    free(pid);
    return 0;
}

void *cal_temperature(void *_args){
    Args *args = (Args *)_args;
    //矩阵按行划分，每个线程计算相同的行数
    for (int j = args->begin + WIDTH / 2; j < WIDTH; j += args->step) {
        for (int i = WIDTH / 2; i < WIDTH; ++ i) {
            ResultMatrix[j][i] = \
                0.25 * (InitMatrix[j - 1][i] + \
                InitMatrix[j + 1][i] + \
                InitMatrix[j][i - 1] + \
                InitMatrix[j][i + 1]);
            if (fabs(ResultMatrix[j][i] - \
        InitMatrix[j][i]) > pow(10.0, -3)) {
                stable_flag = false;
            }
        }
    }
    for (int j = args->begin + WIDTH / 2; j < WIDTH; j += args->step) {
        for (int i = WIDTH / 2; i < WIDTH; ++i) {
            InitMatrix[j][i] = \
            ResultMatrix[j][i];
        }
    }
    return NULL;
}