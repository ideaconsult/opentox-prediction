package org.opentox.wrapper.model;

import java.io.Writer;
import java.net.URLEncoder;
import java.util.Iterator;

import net.idea.restnet.aa.opensso.policy.OpenSSOPoliciesResource;
import net.idea.restnet.aa.resource.AdminResource;
import net.idea.restnet.c.ResourceDoc;
import net.idea.restnet.c.html.HTMLBeauty;
import net.idea.restnet.c.reporters.CatalogHTMLReporter;

import org.opentox.rdf.OpenTox;
import org.opentox.wrapper.Resources;
import org.restlet.Request;
import org.restlet.data.MediaType;
import org.restlet.data.Reference;

public class ModelHTMLReporter extends CatalogHTMLReporter<Model> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8756386166573471502L;
	protected boolean all = true;

	public ModelHTMLReporter(Request request, ResourceDoc doc,
			HTMLBeauty htmlbeauty, boolean all) {
		super(request, doc, htmlbeauty);
		this.all = all;
	}

	@Override
	public void header(Writer output, Iterator<Model> query) {
		super.header(output, query);

		try {
			toolbar(output,query);
			
			output.write("<table width='90%'>");
			output.write("<tr><th>Model</th><th>Created by</th><th>Algorithm</th>");
		
			output.write("</tr>");
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	public void toolbar(Writer w, Iterator<Model> query) throws Exception {
		Reference uri = getRequest().getResourceRef().clone();
		uri.setQuery(null);

			if (!all) {
					//w.write(String.format("<h3>Predict %s</h3>",uri));
					StringBuilder curlHint = new StringBuilder();
					curlHint.append("curl -X POST -H 'subjectid:TOKEN'");
					curlHint.append(String.format(" -H 'Content-Type:%s'",MediaType.APPLICATION_WWW_FORM.getName()));
					curlHint.append(String.format(" -d '%s=%s'",OpenTox.params.dataset_uri,"Dataset URI"));
					curlHint.append(String.format(" -d '%s=%s'",OpenTox.params.dataset_service,"Dataset service"));
					
					curlHint.append(" ");
					curlHint.append(uri);
					output.write("<form method='POST' action=''>");
					w.write("<table width='99%'>\n");
					output.write(String.format("<tr><td>API call</td><td title='How to apply model via OpenTox API (cURL example)'><h5>%s</h5></td></tr>",curlHint));
					output.write("</form>");

				
			}


			if (all) {
				w.write("<h3>Models</h3>");
				output.write(String.format("<a href='%s%s'>All Models</a>",getRequest().getRootRef(),
							Resources.model));
				output.write(String.format("&nbsp;|&nbsp;<a href='%s/%s/%s?search=%s'>Access rights</a>",getRequest().getRootRef(),AdminResource.resource,OpenSSOPoliciesResource.resource,URLEncoder.encode(uri.toString())));

				
			} else {
				w.write("<h3>Model</h3>");
				
				output.write(String.format("<a href='%s%s'>Back to models</a>",
					getRequest().getRootRef(),Resources.model));
				output.write(String.format("&nbsp;|&nbsp;<a href='%s/%s/%s?search=%s'>Access rights</a>",getRequest().getRootRef(),AdminResource.resource,OpenSSOPoliciesResource.resource,URLEncoder.encode(uri.toString())));
				output.write(String.format("&nbsp;|&nbsp;<form action='%s?method=DELETE' method='POST'><INPUT type='submit' value='Delete this model'></form>",uri));

			}
			
			String curlHint = String.format("curl -X GET -H 'Accept:%s' -H 'subjectid:%s' %s","SUPPORTED-MEDIA-TYPE","TOKEN",uri);

			output.write(String.format("<table><tr><td>API call</td><td title='How to retrieve a Model via OpenTox API (cURL example)'><h5>%s</h5></td></tr></table>",
					curlHint));
			output.write("<p>Download Model metadata in supported Media Types:&nbsp;");
			//nmimes
			String paging = "page=0&pagesize=10";
			MediaType[] mimes = {
					MediaType.TEXT_URI_LIST,
					MediaType.APPLICATION_RDF_XML,
					MediaType.TEXT_RDF_N3,
					//MediaType.APPLICATION_JSON,
					//MediaType.TEXT_CSV
					};
			
			String[] image = {
					"link.png",
					"rdf.gif",
					"rdf.gif",
					//"json.png",
					//"excel.png"
			};	
			

			
			for (int i=0;i<mimes.length;i++) {
				MediaType mime = mimes[i];
				output.write("&nbsp;");
				
				
				curlHint = String.format("curl -X GET -H 'Accept:%s' -H 'subjectid:%s' %s",mime,
						"TOKEN",
						uri);
				output.write(String.format(
						"\n<a href=\"%s%s?media=%s&%s\"  ><img src=\"%s/images/%s\" alt=\"%s\" title=\"%s\" border=\"0\"/></a>\n",
						getRequest().getResourceRef(),
						"",
						Reference.encode(mime.toString()),
						paging,
						getRequest().getRootRef().toString(),
						image[i],
						mime,
						curlHint
						));	
			}				
			//tables

	}
	@Override
	public void processItem(Model item, Writer output) {
		try {
			String t = super.getURI(item);
			output.write(String.format("<tr><td><a href='%s'>%s</a></td><td>%s</td><td><a href='%s' target='algorithm'>%s</a></td>", 
					t,item.getTitle(),
					item.getCreator(),
					item.getAlgorithm()==null?"":item.getAlgorithm().getUri(),
					item.getAlgorithm()==null?"N/A":item.getAlgorithm().getUri()
					));
			if (!all) {
				printForm(output,null,true);
			}

			output.write("</tr>");
		} catch (Exception x) {
			x.printStackTrace();
		}
	};
	
	@Override
	public void footer(Writer output, Iterator<Model> query) {
		try {
			output.write("</table>");
		} catch (Exception x) {
			
		}
		super.footer(output, query);
	}
	
	protected void printForm(Writer output, Model model, boolean editable) throws Exception {
		output.write("<tr bgcolor='#B2E203'><form method='POST'>");
		output.write("<th bgcolor='#B2E203'>Enter Dataset URI</th><td bgcolor='#B2E203'><input type='text' name='dataset_uri' title='OpenTox dataset uri' value='' size='80'></td>");
		output.write("<td bgcolor='#B2E203' align='right'><input type='submit' name='Predict'></td>");
		output.write("</form></tr>");
	}	
	protected void printTable(Writer output, String uri, Model model) throws Exception {

	}
}
