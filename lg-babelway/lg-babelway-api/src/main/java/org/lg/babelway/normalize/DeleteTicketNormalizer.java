package org.lg.babelway.normalize;

import org.lg.babelway.AbstractNormalizer;

public class DeleteTicketNormalizer extends AbstractNormalizer {
	@Override
	protected String getAction() {
		return "deleteTicket";
	}
}
