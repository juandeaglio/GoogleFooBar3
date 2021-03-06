import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VersionSorterTests
{
    VersionSorter sorter;
    void Setup()
    {
        sorter = new VersionSorter();
    }
    @Test
    void GivenListOfLength1ShouldReturnOriginalList()
    {
        String[] input = {"1.0"};
        Setup();
        String[] list = sorter.OrganizeVersionList(input);
        Assertions.assertArrayEquals(input,list);
    }
    @Test
    void GivenListOfLength5ShouldSortList()
    {
        String[] input = {"1.1.2","1.0","1.3.3","1.0.12","1.0.2"};
        String[] expectedOut = {"1.0","1.0.2","1.0.12","1.1.2","1.3.3"};
        Setup();
        String[] list = sorter.OrganizeVersionList(input);
        Assertions.assertArrayEquals(expectedOut,list);
    }
    @Test
    void GivenListOfLength8ShouldSortList()
    {
        String[] input = {"1.11","2.0.0","1.2","2","0.1","1.2.1","1.1.1","2.0"};
        String[] expectedOut = {"0.1","1.1.1","1.2","1.2.1","1.11","2","2.0","2.0.0"};
        Setup();
        String[] list = sorter.OrganizeVersionList(input);
        Assertions.assertArrayEquals(expectedOut,list);
    }
    @Test
    void GivenTwoSimilarStringShouldCompareThem()
    {
        String string1 = "1.0.12";
        String string2 = "1.0.2";
        Setup();
        int expectedOutput = 1;
        Assertions.assertEquals(expectedOutput, sorter.CompareVersions(string1, string2));
    }
    @Test
    void GivenTwoSimilarStringShouldCompareThem1()
    {
        String string1 = "100";
        String string2 = "1";
        Setup();
        Assertions.assertTrue( Integer.parseInt(string1) > Integer.parseInt(string2));
    }
}
