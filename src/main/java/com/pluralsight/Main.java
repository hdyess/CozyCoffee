package com.pluralsight;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main {

	public static String musicPath = ConsoleHelper.promptForString("Enter path to music file: ");

	public static void main(String[] args) {



		try {
			Clip clip = AudioSystem.getClip();
			System.out.println();
			File musicFile = new File(musicPath);

			AudioInputStream inputStream = AudioSystem.getAudioInputStream(musicFile);
			System.out.println(inputStream.getFormat());

			clip.open(inputStream);
			clip.start();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		WindowHandler.initWindows();

	}
}
