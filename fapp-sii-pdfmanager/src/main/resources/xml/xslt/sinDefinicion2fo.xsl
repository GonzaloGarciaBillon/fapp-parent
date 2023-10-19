<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:tedbarcode="cl.fapp.pdfmanager.xsltextensions.TimbreExtension"
	extension-element-prefixes="tedbarcode"
	xmlns:barcode="org.krysalis.barcode4j.xalan.BarcodeExt"
	xmlns:common="http://exslt.org/common"
	xmlns:xalan="http://xml.apache.org"
	exclude-result-prefixes="barcode common xalan">

	<xsl:output method="xml" version="1.0"
		omit-xml-declaration="no" indent="yes" />

	<xsl:param name="versionParam" select="'1.0'" />
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simple"
					page-width="7.5cm" page-height="7.5cm"  margin-top="1cm" margin-left="1cm"
					margin-right="1cm">
					<fo:region-body margin-top="0cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>


			<fo:page-sequence master-reference="simple">
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates
						select="BOLETADefType/Documento" />
				</fo:flow>
			</fo:page-sequence>

		</fo:root>
	</xsl:template>


	<xsl:template match="BOLETADefType/Documento">
		<fo:block>
			<fo:block-container width="5.5cm"
				border-color="grey" border-style="solid" border-width="0.3mm"
				padding="1mm">
				<fo:block font-size="12pt" font-family="Helvetica"
					color="grey" text-align="center" hyphenate="false">
					NO ESTA DEFINIDO EL TIPO DE DOCUMENTO
				</fo:block>
			</fo:block-container>
		</fo:block>
	</xsl:template>

</xsl:stylesheet>
