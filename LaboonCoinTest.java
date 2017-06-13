/* Xavier Torgerson CS1632 */
import static org.junit.Assert.*;

import org.junit.*;

public class LaboonCoinTest {

    /**
     * Assert that creating a new LaboonCoin instance
     * does not return a null reference
     */
    @Test
    public void testLaboonCoinExists() {

		LaboonCoin l = new LaboonCoin();
		assertNotNull(l);

    }

    //Assert that creating a block string properly formats a normally formatted input.
    @Test
    public void testCreateBlockNormal() {
    	LaboonCoin coin = new LaboonCoin();
    	assertEquals("Lets go Pens|00000000|001AA59C|000E854A", coin.createBlock("Lets go Pens", 0, 1746332, 951626));
    }

    //Assert that creating a block string properly formats various int->hex string edge cases (Edge Case)
    @Test
    public void testCreateBlockMaxValues() {
    	LaboonCoin coin = new LaboonCoin();
		  assertEquals("boo|00000000|FFFFFFFF|0000000B", coin.createBlock("boo", 0, -1, 11));
    }

    //Assert that creating a block string functions properly when the data string is empty. (Edge Case)
    @Test
    public void testCreateBlockNullString() {
    	LaboonCoin coin = new LaboonCoin();
		  assertEquals("|00000000|FFFFFFFF|0000000B", coin.createBlock("", 0, -1, 11));
    }

    //Assert that block chains print format is appropriate.
    @Test
    public void testBlockChainSingleOutput() {
	    LaboonCoin temp = new LaboonCoin();
      temp.blockchain.add("hi|00000000|000017cc|666ddddd");
	    assertEquals("hi|00000000|000017cc|666ddddd\n", temp.getBlockChain());
    }

    //Assert that  block chains with multiple plocks are correctly output.
    @Test
    public void testBlockChainMultipleOutput() {
	    LaboonCoin temp = new LaboonCoin();
      temp.blockchain.add("who|00000000|11111111|22222222");
      temp.blockchain.add("what|33333333|44444444|55555555");
	    assertEquals("who|00000000|11111111|22222222\nwhat|33333333|44444444|55555555\n", temp.getBlockChain());
    }

    //Assert that block chains with no plocks are correctly output.
    @Test
    public void testBlockChainNoOutput() {
      LaboonCoin temp = new LaboonCoin();
      assertEquals("", temp.getBlockChain());
    }

    //Assert that the regular positive integer 11 is a valid hash when difficulty is 0.
    @Test
    public void testHashZeroDifficulty() {
	    LaboonCoin temp = new LaboonCoin();
	    assertEquals(true, temp.validHash(0, 11));
    }

    //Assert that -1 is a valid hash when difficulty is 0.
    @Test
    public void testHashZeroDifficultyMax() {
	    LaboonCoin temp = new LaboonCoin();
	    assertEquals(true, temp.validHash(0, -1));
    }

    //Assert that 0 is a valid hash when difficulty is 8.
    @Test
    public void testHashMaxDifficulty() {
	    LaboonCoin temp = new LaboonCoin();
	    assertEquals(true, temp.validHash(8, 0));
    }

    //Assert that a non-zero integer is an invalid hash when the difficulty is 8.
    @Test
    public void testHashMaxDifficultyNonZero() {
	    LaboonCoin temp = new LaboonCoin();
	    assertEquals(false, temp.validHash(8, 1));
    }

    //Assert that -1 is invalid when difficulty is 8.
    @Test
    public void testHashMaxDifficultyMax() {
	    LaboonCoin temp = new LaboonCoin();
      assertEquals(false, temp.validHash(8, -1));
    }

}
