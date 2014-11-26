package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;

public class ChainCensorDecoratorTest extends AbstractSocialChanneldDecoratorTest {

	@Test
	public void testChainThreeDecorators() {
		SocialChannelBuilder builder = createTestSpySocialChannelBuilder();
		SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);
		SocialChannel channel = builder.with(new MessageTruncator(10)).with(new URLAppender("http://jpereira.eu"))
				.with(new WordCensor("Microsoft")).getDecoratedChannel(props);

		channel.deliverMessage("Microsoft Windows is grat!");

		TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);

		assertEquals("Microso... http://jpereira.eu ", spyChannel.lastMessagePublished());
	}

	@Test
	public void testThreeDecoratorsWithoutBuilder() {
		SocialChannel channel = new TestSpySocialChannel();
		SocialChannel urlAppenderChannel = new URLAppender("http.://jpereira.eu", channel);
		SocialChannel messageTruncatorChannel = new MessageTruncator(10, urlAppenderChannel);
		SocialChannel messageCensorChannel = new WordCensor("Microsoft", messageTruncatorChannel);

		messageCensorChannel.deliverMessage("Microsoft Windows is great!");

		TestSpySocialChannel spy = (TestSpySocialChannel) channel;

		assertEquals("### Win... http.://jpereira.eu", spy.lastMessagePublished());
	}

	@Test
	public void testOtherChainThreeDecorators() {
		SocialChannelBuilder builder = createTestSpySocialChannelBuilder();
		SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);
		SocialChannel channel = builder.with(new URLAppender("http://jpereira.eu")).with(new MessageTruncator(10))
				.with(new WordCensor("Microsoft")).getDecoratedChannel(props);

		channel.deliverMessage("Microsoft Windows is grat!");

		TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);

		assertEquals("Microso... ", spyChannel.lastMessagePublished());
	}

}
