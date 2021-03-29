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
        for(int i = startIndex; i <= endIndex-1; i++)
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
        String firstString = string1;
        String secondString = string2;
        int smallerWord = -1;
        while(smallerWord == -1 && firstString.length() > 0 && secondString.length() > 0)
        {
            String version1;
            String version2;
            if(firstString.contains("."))
                version1 = firstString.substring(0, firstString.indexOf("."));
            else
                version1 = firstString;

            if(secondString.contains("."))
                version2 = secondString.substring(0, secondString.indexOf("."));
            else
                version2 = secondString;

            if(Integer.parseInt(version1) > Integer.parseInt(version2))
            {
                smallerWord = 2;
            }
            else if(Integer.parseInt(version1) < Integer.parseInt(version2))
            {
                smallerWord = 1;
            }
            else
            {
                if (!firstString.contains("."))
                    smallerWord = 1;
                else if (!secondString.contains("."))
                    smallerWord = 2;
            }

            firstString = firstString.substring(firstString.indexOf(".")+1);
            secondString = secondString.substring(secondString.indexOf(".")+1);
        }
        int result;
        if(smallerWord == -1)
            result = 0;
        else if(smallerWord == 1)
            result = -1;
        else
            result = 1;
        return result;
    }
}
