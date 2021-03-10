import java.util.*;

/**
 * Problem description:
 * A company registers an IPO on a website "sellshares.com".
 * <p>
 * bidding window -> end of which, an auction logic is used
 * <p>
 * Aim: allot shares until there are no more shares or users left, whichever occurs earlier
 * <p>
 * Bid format: [user id, number of shares, bidding price, timestamp]
 * <p>
 * Auction logic:
 * # Bidder with highest price, gets the number of shares they bid for
 * ## Multiple bidders have bid at the same price - each bidder in the same price group
 * gets assigned one share consecutively, with each bidder being arranged
 * inside the group based on their timestamp.
 * Once a bidder gets the number of shares they bid for, they will be removed
 * from the above iterative process. Process then continues until all bidders
 * are removed or the shares get exhausted, whichever comes first.
 * <p>
 * Output: List the user Id's of all users who did not get even one share,
 * after the shares have been allocated.
 * <p>
 * Sample Input:
 * # total shares = 18, [[1,5,5,0], [2,7,8,1], [3,7,5,1], [4,10,3,3]]
 * ## total shares = 3, [[1,2,5,0],[2,1,4,2],[3,5,4,6]]
 *
 * Sample output:
 * # [4]
 * ## [3]
 */

public class AuctionChallenge {

    public static void main(String... args) {
        inputScenario1();
        inputScenario2();
    }

    private static void inputScenario1() {
        List<Integer> user1 = Arrays.asList(1, 5, 5, 0);
        List<Integer> user2 = Arrays.asList(2, 7, 8, 1);
        List<Integer> user3 = Arrays.asList(3, 7, 5, 1);
        List<Integer> user4 = Arrays.asList(4, 10, 3, 3);
        List<Integer> user5 = Arrays.asList(4, 10, 5, 3);
        int a = 2^5;

        List<List<Integer>> bids = Arrays.asList(user1, user2, user3, user4, user5);

        System.out.println("Auction begins---->");
        List<Integer> unallottedUserIds = getUnallottedUsers(bids, 18);
        System.out.println("Auction ends---->");
        System.out.println("Unallotted user ->" + unallottedUserIds);
    }

    private static void inputScenario2() {
        List<Integer> user1 = Arrays.asList(1, 2, 5, 0);
        List<Integer> user2 = Arrays.asList(2, 1, 4, 2);
        List<Integer> user3 = Arrays.asList(3, 5, 4, 6);

        List<List<Integer>> bids = Arrays.asList(user1, user2, user3);

        System.out.println("Auction begins---->");
        List<Integer> unallottedUserIds = getUnallottedUsers(bids, 3);
        System.out.println("Auction ends---->");
    }

    public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
        Map<Integer, List<List<Integer>>> userBidsMap = new HashMap<>(); // {bid_price, [[userX],[userY],...]}
        List<Integer> listOfUniquePriceGroups = new ArrayList();
        List<Integer> unallottedUserIds = new ArrayList<>();
        int counter = 0;
        for (List<Integer> userBid : bids) {
            // userBid = List<Integer>;
            // [user_id,no_of_shares,bidding_price,time_of_bidding]
            List<List<Integer>> bidPerPriceGroup = null;
            int biddingPrice = userBid.get(2);
            if (userBidsMap.containsKey(biddingPrice)) {
                bidPerPriceGroup = userBidsMap.get(biddingPrice);
            } else {
                bidPerPriceGroup = new ArrayList<List<Integer>>();
                userBidsMap.put(biddingPrice, bidPerPriceGroup);
                listOfUniquePriceGroups.add(biddingPrice);
            }
            bidPerPriceGroup.add(userBid);
            //sort unique bidding prices - natural order
            Collections.sort(listOfUniquePriceGroups, Collections.reverseOrder());
            //sort bids of same price group, based on natural order of timestamp value; bidData.get(3)
            userBidsMap.get(biddingPrice).sort(Comparator.comparing(bid -> bid.get(3)));
        }

        final int[] temp = {totalShares};
        listOfUniquePriceGroups.stream().forEach(biddingPrice -> { // reverse order of Integer
            List<List<Integer>> userBidsPerPriceGroup = userBidsMap.get(biddingPrice); // list sorted by timestamp
            userBidsPerPriceGroup.stream().forEach(userBid -> {
                if (temp[0] > 0) {
                    if (userBid.get(1) > temp[0]) {
                        temp[0] = 0;
                    } else {
                        temp[0] -= userBid.get(1);
                    }
                } else {
                    unallottedUserIds.add(userBid.get(0));
                }
            });
            System.out.println("Unallotted user ->" + unallottedUserIds);
        });
        System.out.println("List of Unique price groups, post sorting -> " + listOfUniquePriceGroups);
        System.out.println("User Bid Map, post sorting per price group -> " + userBidsMap);
        return unallottedUserIds;
    }
}
