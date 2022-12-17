// https://practice.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/1

class Node{
    public char val;
    public boolean eow;
    public Map<Character, Node> table = new HashMap<>();

    public Node(char val, boolean eow){this.val = val; this.eow = eow;}

    public String toString(){
        return "{ val: " + val + ", eow: " + eow + ", table: " + table + "}";
    }
}

class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        String[] ans = new String[N];
        Node root = new Node('.', false);
        // creating trie
        for(String s: arr) insert(root, s, 0);
        
        for(int i=0; i< N; i++) {
            String s = arr[i];
            int p = minPrefix(root, s, 0);
            ans[i] = s.substring(0, Math.min(s.length(), p+1));
        }
        return ans;
    }
    
    static int minPrefix(Node node, String s, int pos){
        if(pos >= s.length()) {
            // if last char have more node in table then return string length
            if(node.table.size() > 0) return s.length();
            return 0;
        }
        char c = s.charAt(pos);
        int tmp = minPrefix(node.table.get(c), s, pos+1);
        // if next node table has more than 1 entry or have chars after end of same word 
        if(node.table.get(c).table.size() > 1 | (node.table.get(c).eow && pos != s.length()-1)) return Math.max(tmp, pos+1);
        return tmp;
    }
    
    static void insert(Node node, String s, int pos){
        if(pos >= s.length()) return;
        char c = s.charAt(pos);
        if(!node.table.containsKey(c)) node.table.put(c, new Node(c, false));
        if(pos == s.length()-1) node.table.get(c).eow = true;
        insert(node.table.get(c), s, pos+1);
    }
};
