package com.kaka.LC71_80.topic71;

/**
 * @Author : kaka
 * @Date: 2022-02-14 18:14
 *
 * @Description: 470. 用 Rand7() 实现 Rand10()
 *
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 *
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 *
 */
public class ImplRand10 {
    /**
     * 思路：
     *  *
     *  * （1）由大的随机数 生成小的随机数是方便的，如 rand10 -> rand7
     *  *      只需要用 rand10 生成等概率的 1 ~ 10 ，然后判断生成的随机数 num ，如果 num <= 7 ，则返回即可
     *  *
     *  * （2）如何由小的随机数生成大的随机数呢？
     *  *      考虑这样一个事实：
     *  *      randX() 生成的随机数范围是 [1...X]
     *  *      (randX - 1) * Y + randY() 可以等概率的生成的随机数范围是 [1, X*Y]
     *  *     因此， 可以通过 (rand7 - 1) * 7 + rand7() 等概率的生成 [1...49]的随机数
     *  *     我们可以选择在 [1...10] 范围内的随机数返回。
     *  *
     *  * （3）上面生成 [1...49] 而 我们需要 [1...10]，[11...49]都要被过滤掉，效率有些低
     *  *      可以通过减小过滤掉数的范围来提高效率。
     *  *      比如我们保留 [1...40]， 剩下 [41...49]
     *  *      为什么保留 [1...40] 呢？ 因为对于要生成 [1...10]的随机数，那么
     *  *      可以等概率的转换为 1 + num % 10 , suject to num <= 40
     *  *      因为 1 ... 40 可以等概率的映射到 [1...10]
     *  *      那么如果生成的数在 41...49 怎么办呢？，这些数因为也是等概率的。
     *  *      我们可以重新把 41 ... 49 通过 num - 40 映射到 1 ... 9，可以把 1...9 重新看成一个
     *  *      通过 rand9 生成 rand10 的过程。
     *  *      (num - 40 - 1) * 7 + rand7() -> [1 ... 63]
     *  *      if(num <= 60) return num % 10 + 1;
     *  *
     *  *      类似的，[1...63] 可以 划分为 [1....60] and [61...63]
     *  *      [1...60] 可以通过 1 + num % 10 等概率映射到 [1...10]
     *  *      而 [61...63] 又可以重新重复上述过程，先映射到 [1...3]
     *  *      然后看作 rand3 生成 rand10
     *  *
     *  *      (num - 60 - 1) * 7 + rand7() -> [1 ... 21]
     *  *      if( num <= 20) return num % 10 + 1;
     *  *
     *  *      注意：这个映射的范围需要根据 待生成随机数的大小而定的。
     *  *      比如我要用 rand7 生成 rand9
     *  *      (rand7() - 1) * 7 + rand7() -> [1...49]
     *  *      则等概率映射范围调整为 [1...45]， 1 + num % 9
     *  *      if(num <= 45) return num % 9 + 1;
     *  */
    public int rand10(){

    }
}
