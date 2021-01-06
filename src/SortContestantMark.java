import java.util.*;

/**
 * 对选手的成绩进行排序
 * @author Marco
 */
public class SortContestantMark {
    public List<Map.Entry<String,Contestant>> sortContestantMark(Map<String,Contestant> treeMap){
        List<Map.Entry<String,Contestant>> list = new ArrayList<Map.Entry<String,Contestant>>(treeMap.entrySet());
        list.sort(new Comparator<Map.Entry<String, Contestant>>() {
            @Override
            public int compare(Map.Entry<String, Contestant> o1, Map.Entry<String, Contestant> o2) {
                return Integer.compare(o2.getValue().getMark(), o1.getValue().getMark());
            }
        });
        return list;
    }
}
