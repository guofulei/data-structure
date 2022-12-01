<h1>关于数组</h1>
<h3>稀疏数组</h3>
<p>这是一个二维数组：<p>
<img src="https://user-images.githubusercontent.com/74183122/204961368-f2bb665e-79f9-4018-9c42-77fee070c6cc.png"/></br>
数组中只有大于0的数值是有效值 而那些0相当于是未使用 但他们同时会占用内存空间。
<p>这是一个稀疏数组：</p>
<img src="https://user-images.githubusercontent.com/74183122/204962177-58135c62-fae4-49b4-ae51-86f1554024b8.png"/>
稀疏数组相对于二维数组会节省下很大一块内存空间
<p>将二维数组转稀疏数组的思路:</p>
<ul>
  <li>遍历二维数组统计有效值的个数 sum</li>
  <li>创建稀疏数组sparsearray[sum+1][3]</li>
  <li>再次遍历二维数组,将有效值存入稀疏数组中</li>
</ul></br>
注：稀疏数组第一行 存储的是二维数组的大小和有效值个数从第二行开始存储的是每个有效值的位置和大小
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/array/SparseArrayDemo.java">demo</a>
