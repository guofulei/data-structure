<h1>关于递归</h1>
<h3>递归的概念</h3>
递归就是方法自己调用自己,每次调用时传入不同的变量
<h3>递归需要遵守的重要规则</h3>
<ul>
  <li>执行一个方法时， 就创建一个新的受保护的独立空间(栈空间)</li>
  <li>方法的局部变量是独立的， 不会相互影响, 比如 n 变量</li>
  <li>如果方法中使用的是引用类型变量(比如数组)， 就会共享该引用类型的数据</li>
  <li>递归必须向退出递归的条件逼近， 否则就是无限递归，出现 StackOverflowError(堆栈溢出)</li>
  <li>当一个方法执行完毕， 或者遇到 return， 就会返回， 遵守谁调用， 就将结果返回给谁， 同时当方法执行完毕或者返回时， 该方法也就执行完毕</li>
</ul>
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/recursion/RecursionDemo.java">demo</a>
<h3>八皇后问题(回溯法)</h3>
<div>&nbsp;&nbsp;&nbsp是由国际象棋棋手马克斯·贝瑟尔于1848年提出的问题，是回溯算法的典型案例。
问题表述为：在8×8格的国际象棋上摆放8个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。高斯认为有76种方案。1854年在柏林的象棋杂志上不同的作者发表了40种不同的解，后来有人用图论的方法解出92种结果。如果经过±90度、±180度旋转，和对角线对称变换的摆法看成一类，共有42类。计算机发明后，有多种计算机语言可以编程解决此问题。</div>
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/recursion/EightQueensDemo.java">demo</a>


