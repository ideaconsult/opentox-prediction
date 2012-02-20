package org.opentox.wrapper;

import java.io.IOException;
import java.io.Writer;

import net.idea.restnet.c.ResourceDoc;
import net.idea.restnet.c.html.HTMLBeauty;

import org.restlet.Request;
import org.restlet.data.Reference;

public class OTHTMLBeauty extends HTMLBeauty {
	public OTHTMLBeauty() {
		super();

	};

		@Override
		protected String getHomeURI() {
			return "http://ambit.sf.net";
		}
		@Override
		protected String getLogoURI(String root) {
			return "http://ambit.sourceforge.net/images/ambit-logo.png";
		}
		@Override
		public String getTitle() {
			return "OpenTox algorithm and model service";
		}
		public void writeTopLinks(Writer w,String title,Request request,String meta,ResourceDoc doc, Reference baseReference) throws IOException {
			w.write(String.format("<a href='%s%s'>Algorithms</a>&nbsp;",baseReference,Resources.algorithm));
			w.write(String.format("<a href='%s%s'>Models</a>&nbsp;",baseReference,Resources.model));
			w.write(String.format("<a href='%s%s'>Tasks</a>&nbsp;",baseReference,Resources.task));
			w.write(String.format("<a href='%s%s'>Users</a>&nbsp;",baseReference,Resources.user));
		}
	
		@Override
		public String getLoginLink() {
			return "Login";
		}
}
