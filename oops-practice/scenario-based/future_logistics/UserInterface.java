package week2.future_logistics;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		String input = "rTS120A:12/8/21:5:BrickTransport:6:200:40";

		Utility ut = new Utility();

		GoodsTransport gt = ut.parseDetails(input);

		if (!ut.validateTransportId(gt.transportId))
			return;

		if (ut.findObjectType(gt).equals("Timber Transport")) {
			TimberTransport tt = (TimberTransport) (gt);
			System.out.println(tt);
			return;
		}

		BrickTransport bt = (BrickTransport) (gt);
		System.out.println(bt);
	}
}
