package dijkstra.cores.tests;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class Stories extends JUnitStories
{
	@Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            .useStoryLoader(new LoadFromClasspath(this.getClass()))
            .useStoryReporterBuilder(new StoryReporterBuilder()
            	.withDefaultFormats()
            	.withFormats(Format.CONSOLE, Format.TXT)); 
    }
 
	public Stories() {
		super();
		this.configuredEmbedder().embedderControls().doIgnoreFailureInView(true);
		this.configuredEmbedder().candidateSteps().add(new UnitConverterSteps());
	}
 
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("length_converter.story");
	}
}
