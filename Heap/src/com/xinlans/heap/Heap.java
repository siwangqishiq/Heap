package com.xinlans.heap;

public class Heap
{
    private static final int INIT_CAPACITY = 2;
    private int[] data;
    private int currentSize;

    public Heap()
    {
        data = new int[INIT_CAPACITY + 1];
        currentSize = 0;
    }

    private void enLarge()
    {
        // System.out.println("enlarge");
        int originSize = data.length;
        int newSize = 2 * originSize + 1;
        int[] newData = new int[newSize];
        System.arraycopy(data, 0, newData, 0, originSize);
        this.data = newData;
    }

    public void insert(int item)
    {
        int willSize = currentSize + 1;
        if (willSize >= data.length)
        {
            enLarge();
        }

        int hole = willSize;
        if (bubbleUp(hole, item))// 插入新元素 执行上滤操作
        {
            currentSize++;
        }
    }

    public int getRoot()
    {
        return data[1];
    }

    public int deleteMin() throws Exception
    {
        if (currentSize < 1)
        {
            throw new Exception("堆为空");
        }
        int ret = data[1];// 返回根节点上的最小值
        // data[currentSize] = 0;
        if (currentSize != 1)
        {
            data[1] = data[currentSize];// 将最后一个节点的值赋给根节点
            currentSize--;
            bubbleDown(1);
        }
        else
        {// 仅有一个节点
            currentSize--;
        }
        data[currentSize + 1] = 0;
        // System.out.println("now-->" + toString());
        return ret;
    }

    /**
     * 下滤
     */
    private boolean bubbleDown(int pos)
    {
        int j = 1;
        while (pos < currentSize)
        {
            int leftChildPos = getLeftChildAddress(pos);
            int rightChildPos = getRightChildAddress(pos);

            int leftChild = Integer.MAX_VALUE;
            int rightChild = Integer.MAX_VALUE;
            if (leftChildPos <= currentSize)
            {
                leftChild = data[leftChildPos];
            }
            if (rightChildPos <= currentSize)
            {
                rightChild = data[rightChildPos];
            }

            if (leftChild < rightChild)
            {
                // leftChild 与当前值交换
                if (leftChild < data[pos])
                {// 左边子树的节点值小于根节点
                    int temp = data[leftChildPos];
                    data[leftChildPos] = data[pos];
                    data[pos] = temp;
                }

                pos = 2 * pos;
            }
            else
            {
                // rightChild与当前值交换
                if (rightChild < data[pos])
                {
                    int temp = data[rightChildPos];
                    data[rightChildPos] = data[pos];
                    data[pos] = temp;
                }

                pos = 2 * pos + 1;
            }

            // StringBuffer sb = new StringBuffer();
            // for (int i = 1; i <= currentSize; i++)
            // {
            // sb.append(data[i]).append("   ");
            // }// end for i
            // System.out.println("第" + j + "次下滤--->" + sb.toString());
            // j++;

        }// end while
        return true;
    }

    /**
     * 上滤
     */
    private boolean bubbleUp(int pos, int value)
    {
        data[pos] = value;
        int parentPos = getParent(pos);
        while (parentPos >= 1 && data[pos] < data[parentPos])
        {
            // 交换子节点与父节点的值
            int temp = data[pos];
            data[pos] = data[parentPos];
            data[parentPos] = temp;

            // 向上搜索父节点
            pos = parentPos;
            parentPos = getParent(pos);
        }// end while
        return true;
    }

    private int getParent(int p)
    {
        return p / 2;
    }

    private int getLeftChildAddress(int p)
    {
        return p * 2;
    }

    private int getRightChildAddress(int p)
    {
        return p * 2 + 1;
    }

    public void clear()
    {
        for (int i = 1; i <= currentSize; i++)
        {
            data[i] = 0;
        }// end for i
        currentSize = 0;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= currentSize; i++)
        {
            sb.append(data[i]).append("   ");
        }// end for i
        return sb.toString();
    }
}// end class
