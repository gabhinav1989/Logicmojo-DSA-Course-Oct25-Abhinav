package class20251025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopFrequent {
    public static void main(String[] args){
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
    
        public static int[] topKFrequent(int[] nums, int k) {
            // Count frequency of each number
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
    
            // Group numbers by their frequency using TreeMap (sorted by frequency)
            TreeMap<Integer, List<Integer>> frequencyGroups = new TreeMap<>(Collections.reverseOrder());
            
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                int number = entry.getKey();
                int frequency = entry.getValue();
                
                frequencyGroups.computeIfAbsent(frequency, f -> new ArrayList<>()).add(number);
            }
    
            // Extract top k elements
            int[] result = new int[Math.min(k, frequencyMap.size())];
            int index = 0;
            
            for (List<Integer> numbers : frequencyGroups.values()) {
                for (int num : numbers) {
                    if (index < result.length) {
                        result[index++] = num;
                    }
                }
            }
    
            return result;
        }
    }