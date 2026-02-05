package stream_api;
import java.util.*;
import java.util.stream.Collectors;

 
class Claim {
    private int claimId;
    private String claimType;
    private double claimAmount;

    public Claim(int claimId, String claimType, double claimAmount) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }

    public int getClaimId() {
        return claimId;
    }

    public String getClaimType() {
        return claimType;
    }

    public double getClaimAmount() {
        return claimAmount;
    }
}


public class ClaimAnalyzer {

    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
            new Claim(101, "Health", 25000),
            new Claim(102, "Vehicle", 18000),
            new Claim(103, "Health", 30000),
            new Claim(104, "Travel", 15000),
            new Claim(105, "Vehicle", 22000),
            new Claim(106, "Health", 20000)
        );

        Map<String, Double> averageClaimByType =
            claims.stream()
                  .collect(Collectors.groupingBy(
                      Claim::getClaimType,
                      Collectors.averagingDouble(Claim::getClaimAmount)
                  ));

        averageClaimByType.forEach((type, avgAmount) ->
            System.out.println(type + " → Average Claim Amount: " + avgAmount)
        );
    }
}
