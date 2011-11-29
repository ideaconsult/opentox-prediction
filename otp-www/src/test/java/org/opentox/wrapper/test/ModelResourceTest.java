package org.opentox.wrapper.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.Assert;

import org.junit.Test;
import org.opentox.dsl.OTDataset;
import org.opentox.dsl.OTModel;
import org.opentox.wrapper.model.Model;
import org.opentox.wrapper.model.ModelResource;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;

/**
 * test for {@link PropertyResource}
 * @author nina
 *
 */
public class ModelResourceTest extends ResourceTest {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		//setUpDatabase(dbFile);
		
	}
	@Override
	public String getTestURI() {
		return String.format("http://localhost:%d%s/cadaster24", port,ModelResource.resource);
	}
	
	@Test
	public void testURI() throws Exception {
	//	setUpDatabase(dbFile);
		testGet(getTestURI(),MediaType.TEXT_URI_LIST);
	}
	@Override
	public boolean verifyResponseURI(String uri, MediaType media, InputStream in)
			throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(in));
		String line = null;
		int count = 0;
		while ((line = r.readLine())!= null) {
			Assert.assertEquals(
					String.format("http://localhost:%d%s/P1",port,ModelResource.resource)
							, line);
			count++;
		}
		return count==1;
	}	
	/*
	@Test
	public void testRDF() throws Exception {
		testGet(getTestURI(),MediaType.APPLICATION_RDF_XML);
	}
	
	@Override
	public OntModel verifyResponseRDFXML(String uri, MediaType media,
			InputStream in) throws Exception {
		
		OntModel model = ModelFactory.createOntologyModel();
		model.read(in,null);
		
		ProtocolIO ioClass = new ProtocolIO();
		List<Protocol> protocols = ioClass.fromJena(model);
		Assert.assertEquals(1,protocols.size());
		Assert.assertEquals("http://localhost:8181/protocol/P1",protocols.get(0).getResourceURL().toString());
		Assert.assertEquals("SEURAT-234", protocols.get(0).getIdentifier());
		Assert.assertEquals("Very important protocol", protocols.get(0).getTitle());
		Assert.assertNotNull(protocols.get(0).getAbstract());
		return model;
	}
	*/
	@Override
	public Object verifyResponseJavaObject(String uri, MediaType media,
			Representation rep) throws Exception {
		Object o = super.verifyResponseJavaObject(uri, media, rep);
		Assert.assertTrue(o instanceof Model);

		return o;
	}
	@Test
	public void testPredict() throws Exception {
		
		OTDataset dataset = new OTDataset("http://localhost:8080/ambit2/compound/1001/conformer/3635");
		
		OTModel model = new OTModel(getTestURI());
		OTDataset result = model.predict(dataset);
		System.out.println(result);
	}
}
