package org.lg.babelway.normalize;

import org.junit.Test;
import org.lg.babelway.hors.NormalizerException;
import org.lg.babelway.test.UnitNormalizer;
import org.lg.hors.AbstractException;

public class TicketNormalizerTest {
	// action = /ticket
	@Test(expected = NormalizerException.class)
	public void testErrTicket() throws AbstractException {
		UnitNormalizer.testNormalizer(TicketNormalizer.class, "ticket-key-failure");
	}
	@Test
	public void testSucTicket() throws AbstractException{
		UnitNormalizer.testNormalizer(TicketNormalizer.class, "ticket-key-success");
	}
	// action = /deleteTicket
	@Test(expected = NormalizerException.class)
	public void testErrDeleteTicket() throws AbstractException {
		UnitNormalizer.testNormalizer(DeleteTicketNormalizer.class, "deleteTicket-key-failure");
	}
	@Test
	public void testSucDeleteTicket() throws AbstractException{
		UnitNormalizer.testNormalizer(DeleteTicketNormalizer.class, "deleteTicket-key-success");
	}
	// action = /tickets
	@Test(expected = NormalizerException.class)
	public void testErrTickets() throws AbstractException{
		UnitNormalizer.testNormalizer(TicketsNormalizer.class, "tickets-status-failure");
	}
	@Test
	public void testSucTickets() throws AbstractException{
		UnitNormalizer.testNormalizer(TicketsNormalizer.class, "tickets-nostatus-success");
	}
}
