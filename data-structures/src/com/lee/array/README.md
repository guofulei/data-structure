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
</ul>
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/array/SparseArrayDemo.java">demo</a></br>
注：稀疏数组第一行 存储的是二维数组的大小和有效值个数从第二行开始存储的是每个有效值的位置和大小 </br>
<h3>合并两个有序数组</h3>
<p>数组a:</p>
<img src="https://user-images.githubusercontent.com/74183122/204986781-a10c332b-7d03-42d6-9bd1-7991911ac895.png"/>
<p>数组b:</p>
<img src="https://user-images.githubusercontent.com/74183122/204986789-48198f82-8d3d-4334-b8f4-c5b57c15ea45.png"/>
<p>思路:</p>
<ul>
  <li>使用双指针的方法，把a,b数组看成队列</li>
  <li>同时从a,b队列头部取出元素,如果a的元素小于b的元素,就将a的元素放到新队列中,a队列索引+1,b不变</li>
  <li>如果b小于a,同上操作</li>
  <li>最后肯定有一个队列有剩余元素,利用上面的索引取遍历数组,将他们添加到新队列即可</li>
</ul>
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/array/OrderArrayDemo.java">demo</a>
<h3>环形队列</h3>
<img src="https://user-images.githubusercontent.com/74183122/204996425-97fe56f7-26a7-43bc-8a3c-b728f6797ce2.png"/>
队空时状态:
<img src="https://user-images.githubusercontent.com/74183122/205203016-74f3d172-41b7-40db-be4a-449d20304c28.png"/>
队满时状态:
<img src="https://user-images.githubusercontent.com/74183122/205203022-dc9e4052-fac7-4237-92e5-b0b0265161b7.png"/>

<p>思路:</p>
<ul>
  <li>front指向队列头部 默认0,end指向队列尾部 默认0</li>
  <li>队空的条件是end==front</li>
  <li>队满的条件是(end+1)%maxSize=0</li>
  <li>队列有效元素个数表达式:(end+maxSize-front)%maxSize</li>
</lu>
<p></p>
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/array/CircleDemo.java">demo</a>
