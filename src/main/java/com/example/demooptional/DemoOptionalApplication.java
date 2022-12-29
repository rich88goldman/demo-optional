package com.example.demooptional;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoOptionalApplication implements CommandLineRunner{

	private static Logger logger = LoggerFactory.getLogger(DemoOptionalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoOptionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("--- getting winning alliance\n");
		FMS fms = initSample(true);
		logger.info("with prevColor     = {}", getWinnerPrevColor(fms));
		logger.info("with prevColor-OPT = {}", getWinnerPrevColorOpt(fms));

		fms = initSample(false);
		logger.info("without prevColor     = {}", getWinnerPrevColor(fms));
		logger.info("without prevColor-OPT = {}", getWinnerPrevColorOpt(fms));
	}

	FMS initSample(boolean withColor){
		FMS fms = FMS.defaultInstance();
		fms.setCurrentMatch(new CurrentMatch(new ActiveSession(new Alliance(withColor ? "Red" : null))));
		return fms;
	}

	String getWinnerPrevColor(FMS fms){
		String prevColor=null;
		CurrentMatch cm = fms.getCurrentMatch();
		if(cm != null){
			ActiveSession asn = cm.getActiveSession();
			if(asn!=null){
				Alliance al = asn.getWinningAlliance();
				if(al!=null){
					prevColor = al.getPreviousColor();
					if(prevColor==null){
						return "N/A";
					}
				}
			}
		}
		return prevColor;
	}

	String getWinnerPrevColorOpt(FMS fms){
		return Optional.ofNullable(fms.getCurrentMatch())
		.map(CurrentMatch::getActiveSession)
		.map(ActiveSession::getWinningAlliance)
		.map(Alliance::getPreviousColor)
		.orElse("N/A");
	}

}
