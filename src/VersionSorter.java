public class VersionSorter
{
    public String[] OrganizeVersionList(String[] unsortedList)
    {
        if(unsortedList.length == 1)
            return unsortedList;
        else
        {
            return QuickSort(unsortedList, 0, unsortedList.length - 1);
        }
    }

    public String[] QuickSort(String[] list, int startIndex, int endIndex)
    {

        if(startIndex < endIndex)
        {
            int pivotIndex = Partition(list, startIndex, endIndex);
            QuickSort(list, startIndex, pivotIndex-1);
            QuickSort(list, pivotIndex+1, endIndex);
        }
        return list;
    }

    private int Partition(String[] list, int startIndex, int endIndex)
    {
        String pivot = list[endIndex];
        int pivotIndex = startIndex;
        for(int i = startIndex; i < endIndex; i++)
        {
            if(CompareVersions(list[i],pivot) <= 0)
            {
                Swap(list, i, pivotIndex);
                pivotIndex++;
            }
        }
        Swap(list, pivotIndex, endIndex);
        return pivotIndex;
    }

    private void Swap(String[] list, int index1, int index2)
    {
        String temp = list[index2];
        list[index2] = list[index1];
        list[index1] = temp;
    }

    public int CompareVersions(String string1, String string2)
    {
        int smallerWord = -1;
        int largerIndex = Math.max(string1.length(), string2.length());
        for(int i = 0; i < largerIndex-1 && smallerWord == -1; i++)
        {
            if(i == string1.length())
            {
                smallerWord = 1;
            }
            else if(i == string2.length())
            {
                smallerWord = 2;
            }
            else if(string1.charAt(i) > string2.charAt(i))
            {
                smallerWord = 2;
            }
            else if(string1.charAt(i) < string2.charAt(i))
            {
                smallerWord = 1;
            }
        }
        if(smallerWord == -1)
        {
            return  0;
        }
        else if(smallerWord == 1)
        {
            return -1;
        }
        else
            return 1;
    }
}
