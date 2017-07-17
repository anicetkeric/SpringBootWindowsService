package com.service.procrun;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.service.entity.Booking;
import com.service.repository.BookingRepository;



@SpringBootApplication
public class SpringBootWindowsServiceApplication implements CommandLineRunner {

	 @Autowired
	 BookingRepository bookingRepository;
	
	private static ApplicationContext applicationContext = null;

	public static void main(String[] args) {
	    String mode = args != null && args.length > 0 ? args[0] : null;

	   /* if (logger.isDebugEnabled()) {
	        logger.debug("PID:" + ManagementFactory.getRuntimeMXBean().getName() + 
	                     " Application mode:" + mode + " context:" + applicationContext);
	    }*/
	    if (applicationContext != null && mode != null && "stop".equals(mode)) {
	        System.exit(SpringApplication.exit(applicationContext, new ExitCodeGenerator() {
	            @Override
	            public int getExitCode() {
	                return 0;
	            }
	        }));
	    }
	    else {
	        SpringApplication app = new SpringApplication(SpringBootWindowsServiceApplication.class);
	        applicationContext = app.run(args);
	    /*    if (logger.isDebugEnabled()) {
	            logger.debug("PID:" + ManagementFactory.getRuntimeMXBean().getName() + 
	                         " Application started context:" + applicationContext);
	        }*/
	    }	
	}
	@Override
	public void run(String... args) throws Exception {

		
		Timer timer = new Timer();

		timer.schedule( new TimerTask() {
		    public void run() {
		       // do your work 	
		    	Booking booking=new Booking();
		    	booking.setDeparture("test");
		    	booking.setDestination("dest");
		    	booking.setPsngrName("Psng");
		    	  booking.setTravelDate(new Date());
		    	  bookingRepository.save(booking);
		    }
		 }, 0, 60*1000);
		
		/*#############################################################################################*/	
		
	}
}
