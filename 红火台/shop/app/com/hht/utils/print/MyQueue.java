package com.hht.utils.print;

import java.util.LinkedList;
public class MyQueue  
{
    private LinkedList<PrintJob> list = new LinkedList<PrintJob>();
    private static MyQueue myQueue = null;

    private MyQueue(){

    }
    public static MyQueue getInstance(){
        if(myQueue == null){
            myQueue = new MyQueue();
        }
        return myQueue;
    }
    public void clear()//销毁队列
    {
        list.clear();
    }
    public boolean QueueEmpty()//判断队列是否为空
    {
        return list.isEmpty();

    }
    public void enQueue(PrintJob o)//进队
    {
        synchronized(this){
            list.addFirst(o);
        }
    }
    public Object deQueue()//出队
    {
        synchronized(this){
            if(!list.isEmpty())
            {
                return list.removeFirst();
            }
            return "队列为空";
        }
    }
    public int QueueLength()//获取队列长度
    {
        return list.size();
    }
    public Object QueuePeek()//查看队首元素
    {
        return list.getFirst();
    }
    public boolean exist(Object o){
        return list.contains(o);
    }
}