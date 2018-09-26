package com.newcaoguo.kotlin.demo

fun Find(target: Int, array: IntArray): Boolean {
    return array.contains(target)
}

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
fun main(args: Array<String>) {
    println(Find(5, intArrayOf(1, 2, 35, 53, 6)))
}