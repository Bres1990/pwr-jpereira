package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator {
	private String censoredWord;

	public WordCensor(String censoredWord) {
		this.censoredWord = censoredWord;
	}

	public WordCensor(String censoredWord, SocialChannel channel) {
		this.censoredWord = censoredWord;
		this.delegate = channel;
	}
	// TODO
	@Override
	public void deliverMessage(String message) {
		StringBuilder builder = new StringBuilder();
		String newMessage = "";
		String[] tablica = message.split(" ");
		// System.out.println("moj string przed dzialaniem " + message);
		for (int i = 0; i < tablica.length; i++) {
			if (tablica[i].equals("Microsoft")) {
				tablica[i] = "###";
			}
			newMessage = newMessage + tablica[i] + " ";
		}

		builder.append(newMessage);
		newMessage = builder.toString();
		delegate.deliverMessage(newMessage);
		// System.out.println("moj string po dzialaniu " + newMessage);
		// if (censoredWord.equals("Microsoft")) {
		// StringBuilder builder = new StringBuilder();
		// builder.append("###");
		// builder.append(message.substring(censoredWord.length()));
		// message = builder.toString();
		// }
		//
		// delegate.deliverMessage(message);
	}

}
