/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {
    class LinkNode {
        int val;
        LinkNode next;
    }
    LinkNode dummy;
    int size;

    public MyLinkedList() {
        this.dummy = new LinkNode();
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        LinkNode indexNode = dummy;
        // 在本函数和以下函数中，使用 cur 存储当前节点的下标，dummy 节点的下标被视为 -1
        int cur = -1;
        while (cur != index) {
            indexNode = indexNode.next;
            cur++;
        }
        return indexNode.val;
    }
    
    public void addAtHead(int val) {
        LinkNode newHead = new LinkNode();
        newHead.val = val;

        newHead.next = dummy.next;
        dummy.next = newHead;
        size++;
    }
    
    public void addAtTail(int val) {
        LinkNode newTail = new LinkNode();
        newTail.val = val;

        LinkNode tail = dummy;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newTail;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }

        LinkNode indexNode = dummy;
        int cur = -1;
        while (cur + 1 != index) {
            indexNode = indexNode.next;
            cur++;
        }

        // 插入 indexNode 之后
        LinkNode newNode = new LinkNode();
        newNode.val = val;
        newNode.next = indexNode.next;
        indexNode.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }

        LinkNode indexNode = dummy;
        int cur = -1;
        while (cur + 1 != index) {
            indexNode = indexNode.next;
            cur++;
        }
        indexNode.next = indexNode.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

