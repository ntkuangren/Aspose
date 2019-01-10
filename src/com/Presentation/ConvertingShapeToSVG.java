package com.Presentation;

import java.io.FileOutputStream;
import java.util.Date;

import com.aspose.slides.IChart;
import com.aspose.slides.IMasterSlide;
import com.aspose.slides.IShape;
import com.aspose.slides.ISlide;
import com.aspose.slides.Presentation;

public class ConvertingShapeToSVG {

	public static void main(String[] args) {

		Date date = new Date();
		com.aspose.slides.License license = new com.aspose.slides.License();
		license.setLicense("Aspose.Total.Java.lic");
		String dataDir;
		String pptPath;
		if(args.length < 2) {
			dataDir = "./";
			pptPath = "./demo.pptx";
		} else {
			pptPath = args[0];
			dataDir = args[1];
		}
		Presentation pres = new Presentation(pptPath);
		for (int i = 0; i < pres.getMasters().size(); i++) {
			IMasterSlide master = pres.getMasters().get_Item(i);
			for (int j = 0; j < master.getShapes().size(); j++) {
				IShape shape = master.getShapes().get_Item(j);
				if (shape instanceof IChart) {
					IChart chart = (IChart) shape;
					try {
						FileOutputStream output = new FileOutputStream(dataDir + "SvgImage" + j + ".svg");
						chart.writeAsSvg(output);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.toString());
					}
				}
			}
		}
	}

}
