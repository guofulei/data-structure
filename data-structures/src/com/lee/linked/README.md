<h1>👏关于链表</h1>
<h3>单链表</h3>
<img src="https://user-images.githubusercontent.com/74183122/205238418-ee55cdb3-aa69-4716-bc8b-48946be75621.png"/>
<p>结构</p>
<ul>
  <li>单链表的头部为空不存储数据</li>
  <li>单链表的node存储的是当前节点的数据</li>
  <li>上图可以看到单链表的各个节点的位置是连续的,但他们的物理位置其实是不连续的，每个node节点中的next存储的是他连接下一个节点的地址</li>
  <li>单链表最后一个节点的next一定是null</li>
</ul>
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/linked/LinkedDemo.java">demo</a>
<h3>双向链表</h3>
<img src="https://user-images.githubusercontent.com/74183122/205246952-a548bb2d-4b88-440c-9e73-cc5bfbfb7c51.png"/>
<p>结构</p>
<ul>
  <li>双向链表相较于单链表在每个node中会多一个pre，这个pre的作用和next类似，但他存储的是上一个node的物理位置</li>
  <li>双向链表head的pre为null，链表最后一个node的next为null</li>
</ul>
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/linked/DoubleLinkedDemo.java">demo</a>
<h3>环形链表</h3>
<img src="https://user-images.githubusercontent.com/74183122/205253667-d91c8329-c884-498f-bee6-802cfc23e848.png"/>
<p>结构</p>
<ul>
  <li>123</li>
</ul>
<a href="">demo</a>
