package gov.sanction;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Application;

import org.modelmapper.ModelMapper;

import io.helidon.microprofile.server.Server;



@ApplicationScoped
public class MainApplication extends Application 
{

	public static void main(final String[] args) throws IOException {
		
		Server server = startServer();
		System.out.println("http://localhost:" + server.port());
	}

	static Server startServer() 
	{
		return Server.create().start();
	}
	
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
