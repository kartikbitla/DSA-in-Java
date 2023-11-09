public class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("The Trie has been created");
    }



    //insert method
    public void insert(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Successfully inserted " + word + " in Trie");
    }



    //search method
    public boolean search(String word){
        TrieNode currentNode = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);

            if(node == null){
                System.out.println("Word " + word + " does not exist in Trie");
                return false;
            }

            currentNode = node;
        }

        if(currentNode.endOfString == true){
            System.out.println("Word " + word + " exists in Trie");
            return true;
        }else{
            System.out.println("Word " + word + " does not exist in Trie. But it is a prefix of another string");
        }
        return currentNode.endOfString;
    }


    //Delete a String from Trie
    private boolean delete(TrieNode parentNode, String word, int index){
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;
        
        
        //Case 1 - Some other prefix of string is same as the one that we want to delete. (API, APPLE)   
        if(currentNode.children.size() > 1){            
            currentNode.children.remove(ch);
            return true;
        }


        //Case 2 - The string is a prefix of another string. (API, APIS)
        if(index == word.length()-1){            
            if(currentNode.children.size() >= 1){
                currentNode.endOfString = false;
                return false;
            }else{
                parentNode.children.remove(ch);
                return true;
            }
        }

  
        // Case 3 - Other string is a prefix of this string. (API, AP)   
        if(currentNode.endOfString == true){            
            delete(currentNode, word, index+1);
            return false;
        }



        //Case 4 - Not any node depends on this string.
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if(canThisNodeBeDeleted == true){            
            parentNode.children.remove(ch);
            return true;
        }else{
            return false;
        }
    }


    public void delete(String word){
        if(search(word)){
            delete(root, word, 0);
        }
    }


}