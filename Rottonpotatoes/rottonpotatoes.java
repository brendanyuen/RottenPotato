public class rottonpotatoes{

    
    public static void main(String[] args){

        int[][] ratings = { {4,6,2,5},
                {7,9,4,8},
                {6,9,3,7} };
        int rating = movieAvgRating(ratings, 0); 
        System.out.println("Movie zero's average rating: " + rating);  
        int rating0 = reviewerAvgRating(ratings, 0); 
        System.out.println("Reviewer zero's average rating: " + rating0);

        int rating1 = avgRating2018(ratings); 
        System.out.println("Average rating for 2018 movies: " + rating1);

       
        System.out.println("Hardest reviewer is #" + hardestRater2018(ratings));
        System.out.println("Hardest reviewer is #" + worstMovie2018(ratings));
    }
    
    

    public static int movieAvgRating(int[][] ratings, int movie) {
        double sum=0;

        for(int r=0;r<ratings.length;r++)
            sum+=ratings[r][movie];
        return (int)(sum/(ratings.length));

        
    }

    public static int reviewerAvgRating(int[][] ratings, int reviewer){
        double sum=0;

        for(int c=0;c<ratings[0].length;c++)
            sum+=ratings[reviewer][c];

        return (int)(sum/(ratings[0].length)); 

    }
    
    public static int avgRating2018(int[][] ratings){
        double sum=0;
        int count=0;
        for(int r=0;r<ratings.length;r++){
            for(int c=0;c<ratings[0].length;c++){
                sum+=ratings[r][c]; 
                count++;
            }

        }
        return (int)sum/count;
    }

    public static int hardestRater2018(int[][] ratings){
         int lowScore=reviewerAvgRating(ratings,0);
         int number=0;
        for(int r=1;r<ratings.length;r++){
            int score=reviewerAvgRating(ratings,r);
            if(score<lowScore){
                number=r;
                score=lowScore;
            }
            
        }
        return number;
    }

    
     public static int worstMovie2018(int[][] ratings) {
        int lowScore=movieAvgRating(ratings,0);
         int number=0;
        for(int c=1;c<ratings[0].length;c++){
            int score=movieAvgRating(ratings,c);
            if(score<lowScore){
                number=c;
                score=lowScore;
            }
            
        }
        return number;
    }
}