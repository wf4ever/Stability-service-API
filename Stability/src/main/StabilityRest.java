package main;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import control.GenerateStability;

import rdf.ItemStability;


@Path("/getStability")
public class StabilityRest {
	
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayPlainText() {
		String response="<?xml version=\"1.0\"?>"+
	"<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" "+
    " xmlns:roe=\"http://purl.org/ro/service/evaluate/stability\">"+
    "<rdf:Description rdf:about=\"\">"+
    "<roe:stability>/rest/getStability{?RO,minim,purpose}</roe:stability>"+
    "</rdf:Description></rdf:RDF> ";
	return response;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getStability(@QueryParam("RO") String ro, @QueryParam("minim") String min,@QueryParam("purpose") String ppose) {
		ItemStability item=new ItemStability();
		GenerateStability gs=new GenerateStability(ro,min,ppose);
		gs.evaluate();
		item.fillInfo(gs.getRo(), gs.getValue(), gs.getSnapshots());
		return Response.ok(item).build();
	}

}
