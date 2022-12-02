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
  <li>把单例链表的最后一个元素的next指向head就形成了环形链表</li>
  <li>如果head的next==pre，链表只有一个node</li>
</ul> 
<a href="https://github.com/guofulei/data-structure/blob/main/data-structures/src/com/lee/linked/CircleLinkedDemo.java">demo</a>
<h3>与瑟夫问题</h3>
<div>
<p> 问题描述：<p/>  
    设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
</div>  
<p>思路</p>
<ul>
  <li>声明一个辅助指针，将这个辅助指向链表的尾部</li>
  <li>然后让head和辅助指针通知移动（k-1）次</li>
  <li>循环（报数的人数-1）次出圈...</li>
  <li>直到链表最后只省一个元素 循环结束 将链表最后一个取出 完成出圈</li>
</ul>
