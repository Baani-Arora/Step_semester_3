package oop.assignment_problems;

class InventoryBalancer {

    static void analyzeInventory(int[] sectionA,int[] sectionB){

        int totalA=0,totalB=0;
        int max=-1,index=-1;
        String section="";

        for(int i=0;i<sectionA.length;i++){

            totalA+=sectionA[i];
            totalB+=sectionB[i];

            if(sectionA[i]>max){
                max=sectionA[i];
                section="Section A";
                index=i;
            }

            if(sectionB[i]>max){
                max=sectionB[i];
                section="Section B";
                index=i;
            }
        }

        System.out.println("Section A Total: "+totalA);
        System.out.println("Section B Total: "+totalB);
        System.out.println("Status: "+(totalA==totalB?"Balanced":"Not Balanced"));
        System.out.println("Highest Quantity: "+max+" ("+section+", Item "+(index+1)+")");
    }

    public static void main(String[] args){

        analyzeInventory(
                new int[]{20,15,30},
                new int[]{25,10,30});
    }
}