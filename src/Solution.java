import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        VersionSorter sorter = new VersionSorter();
        String[] toSort = {"1.1.2","1.0","1.3.3","1.0.12","1.0.2"};
        System.out.println(Arrays.toString(sorter.OrganizeVersionList(toSort)));
    }
}
