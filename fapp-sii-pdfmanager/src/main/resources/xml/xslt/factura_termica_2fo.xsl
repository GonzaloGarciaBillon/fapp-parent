<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:tedbarcode="cl.fapp.pdfmanager.xsltextensions.TimbreExtension"
	extension-element-prefixes="tedbarcode" xmlns:barcode="org.krysalis.barcode4j.xalan.BarcodeExt"
	xmlns:common="http://exslt.org/common" xmlns:xalan="http://xml.apache.org"
	exclude-result-prefixes="barcode common xalan">

	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />

	<xsl:param name="versionParam" select="'1.0'" />
	<xsl:param name="logo" />
	<xsl:param name="resolcode" />
	<xsl:param name="resoldate" />


	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simple" page-width="7.5cm" margin-top="0.5cm" page-height="auto"
					margin-left="0.5cm" margin-right="0.5cm" margin-bottom="0cm">
					<fo:region-body margin-top="0cm" margin-bottom="0cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>


			<fo:page-sequence master-reference="simple">
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="DTE/Documento" />
				</fo:flow>
			</fo:page-sequence>

		</fo:root>
	</xsl:template>




	<xsl:template match="DTE/Documento">
		<fo:block>
			<xsl:apply-templates select="Encabezado/Emisor">
				<xsl:with-param name="folio">
					<xsl:value-of select="Encabezado/IdDoc/Folio" />
				</xsl:with-param>
				<xsl:with-param name="tipo">
					<xsl:value-of select="Encabezado/IdDoc/TipoDTE" />
				</xsl:with-param>
			</xsl:apply-templates>
			<!-- 
			<xsl:apply-templates select="Encabezado/Receptor">
				<xsl:with-param name="fecha">
					<xsl:value-of select="Encabezado/IdDoc/FchEmis" />
				</xsl:with-param>
				<xsl:with-param name="medioPago">
					<xsl:value-of select="Encabezado/IdDoc/MedioPago" />
				</xsl:with-param>
				<xsl:with-param name="formaPago">
					<xsl:value-of select="Encabezado/IdDoc/FmaPago" />
				</xsl:with-param>
			</xsl:apply-templates>
			-->

 
         <fo:block>
			<fo:table font-weight="normal" font-size="8pt" font-family="monospace" color="black">
				<fo:table-column column-width="60%" />
				<fo:table-column column-width="40%" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell text-align="left">
						   <fo:block>&#160;</fo:block>
					    </fo:table-cell>
						<fo:table-cell text-align="right">
						   <fo:block>&#160;</fo:block>
					    </fo:table-cell>
					</fo:table-row>
					
					<fo:table-row>
						<fo:table-cell text-align="left" font-weight="bold">
						   <fo:block>Fecha: <xsl:value-of select="concat(' ', substring(TmstFirma,9,2),'/',substring(TmstFirma,6,2),'/',substring(TmstFirma,1,4))" />
						   </fo:block>
					    </fo:table-cell>
						<fo:table-cell text-align="right" font-weight="bold">
						   <fo:block>&#160;Hora: <xsl:value-of select="concat(' ', substring(TmstFirma,12,5))" />
						   </fo:block>
					    </fo:table-cell>
					</fo:table-row>

				</fo:table-body>
			</fo:table>             
         </fo:block>


			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Lista Detalle -->
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<fo:table font-size="8pt" font-family="monospace" color="black" text-align="left" space-before="8pt" margin-bottom="2cm">
				<fo:table-column column-width="50%"/>
				<fo:table-column column-width="20%"/>
				<fo:table-column column-width="15%"/>
				<fo:table-column column-width="15%"/>

				<fo:table-header>

					<fo:table-cell text-align="left" >
						<fo:block>
							<fo:inline font-weight="bold">Detalle</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block>
							<fo:inline font-weight="bold">Cant.</fo:inline>
						</fo:block>
					</fo:table-cell>

					<fo:table-cell text-align="right">
						<fo:block>
							<fo:inline font-weight="bold">P.Unit.</fo:inline>
						</fo:block>
					</fo:table-cell>

					<fo:table-cell text-align="right">
						<fo:block>
							<fo:inline font-weight="bold">Total</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-header>


				<fo:table-body>
					<fo:table-row>
						<fo:table-cell number-columns-spanned="4" border-top-width="0.6pt" border-top-style="solid" height="0.3cm">
							<fo:block/>
						</fo:table-cell>
					</fo:table-row>

					<xsl:apply-templates select="Detalle"/>

					<fo:table-row>
						<fo:table-cell number-columns-spanned="4" border-top-width="0.6pt" border-top-style="solid" height="0.3cm">
							<fo:block/>
						</fo:table-cell>
					</fo:table-row>


					<fo:table-row>
						<fo:table-cell text-align="right" column-number="3" height="0.5cm">
							<fo:block>
								<fo:inline font-weight="regular">Neto</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="right" column-number="4" height="0.5cm">
							<fo:block>
								<fo:inline font-weight="regular">
									<xsl:value-of select="Encabezado/Totales/MntNeto"/>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell text-align="right" column-number="3" height="0.5cm">
							<fo:block>
								<fo:inline font-weight="regular">IVA
									<xsl:value-of select="Encabezado/Totales/TasaIVA"/>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="right" column-number="4" height="0.5cm">
							<fo:block>
								<fo:inline font-weight="regular">
									<xsl:value-of select="Encabezado/Totales/IVA"/>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell text-align="right" column-number="3" height="0.5cm">
							<fo:block>
								<fo:inline font-weight="bold">Total</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="right" column-number="4" height="0.5cm">
							<fo:block>
								<fo:inline font-weight="bold">
									<xsl:value-of select="Encabezado/Totales/MntTotal"/>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

			<xsl:apply-templates select="TED"/>
		</fo:block>
	</xsl:template>


	<xsl:template match="Detalle">
		<fo:table-row>
			<fo:table-cell text-align="left" height="0.5cm">
				<fo:block>
					<xsl:value-of select="NmbItem"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell text-align="center" height="0.5cm">
				<fo:block>
					<xsl:value-of select="QtyItem"/>
					<xsl:value-of select="UnmdItem"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell text-align="right" height="0.5cm">
				<fo:block>
					<xsl:value-of select="PrcItem"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell text-align="right" height="0.5cm">
				<fo:block>
					<xsl:value-of select="MontoItem"/>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>


	<xsl:template match="Emisor">
		<xsl:param name="folio" />
		<xsl:param name="tipo" />

		<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- Recuadro folio -->
		<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<fo:block-container width="6.5cm" border-color="black" border-style="solid" border-width="0.8mm"
			padding="1mm">
			<fo:block font-size="11pt" font-family="Courier" color="black" text-align="center" hyphenate="false">
				R.U.T.:
				<xsl:call-template name="RutFormat">
					<xsl:with-param name="rut">
						<xsl:value-of select="RUTEmisor" />
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-size="11pt" font-family="Courier" color="black" text-align="center">
				<xsl:choose>
					<xsl:when test="$tipo=39">
						BOLETA ELECTRONICA
					</xsl:when>
					<xsl:when test="$tipo=33">
						FACTURA ELECTRONICA
					</xsl:when>
					<xsl:when test="$tipo=52">
						GUIA DE DESPACHO ELECTRONICA
					</xsl:when>
					<xsl:when test="$tipo=56">
						NOTA DE DEBITO ELECTRONICA
					</xsl:when>
					<xsl:when test="$tipo=61">
						NOTA DE CREDITO ELECTRONICA
					</xsl:when>
					<xsl:otherwise>
						NO ESTA DEFINIDO
					</xsl:otherwise>
				</xsl:choose>
			</fo:block>
			<fo:block font-size="11pt" font-family="Courier" color="black" text-align="center">
				N&#176;<xsl:value-of select="$folio" />
			</fo:block>
		</fo:block-container>

		<fo:block-container>
			<fo:block padding-top="0.3mm" font-size="9pt" font-family="Helvetica" font-weight="bold" color="black"
				text-align="center" hyphenate="false">
				SII -
				<xsl:value-of select="CmnaOrigen" />
			</fo:block>
		</fo:block-container>


		<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- Emisor -->
		<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		<fo:block>
		<!-- 
			<fo:external-graphic content-width="scale-to-fit" scaling="uniform" height="2.5cm" width="6.5cm" src="{$logo}" />
		-->
			<fo:external-graphic content-width="scale-to-fit" text-align="center" content-height="scale-to-fit" scaling="uniform" height="2.5cm" width="6.5cm" src="{$logo}" />
		</fo:block>

		<fo:block-container>

			<fo:block font-size="9pt" font-family="sans-serif" font-weight="bold" text-align="left" color="black">
				<xsl:value-of select="RznSocEmisor" />
			</fo:block>

			<xsl:if test="Sucursal">
				<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true"
					color="black" text-align="left">
					Sucursal:
					<xsl:value-of select="Sucursal" />
					(Codigo SII:
					<xsl:value-of select="CdgSIISucur" />
					)
				</fo:block>
			</xsl:if>

			<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true"
				color="black" text-align="left">
				<xsl:value-of select="GiroEmisor" />
			</fo:block>

			<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true"
				color="black" text-align="left">
				<xsl:value-of select="DirOrigen" />
			</fo:block>

			<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true"
				color="black" text-align="left">
				<xsl:value-of select="CmnaOrigen" />, <xsl:value-of select="CiudadOrigen" />
			</fo:block>

		</fo:block-container>

	</xsl:template>




	<!-- Datos del receptor -->
	<xsl:template match="Receptor">
		<xsl:param name="fecha" />
		<xsl:param name="medioPago" />
		<xsl:param name="formaPago" />

		<fo:block-container padding-top="3mm">
			<fo:block font-size="9pt" font-family="Helvetica" space-after="8pt" language="es" hyphenate="true"
				color="black" text-align="left">
				Santiago,
				<xsl:call-template name="FechaFormat">
					<xsl:with-param name="fecha">
						<xsl:value-of select="$fecha" />
					</xsl:with-param>
				</xsl:call-template>

			</fo:block>


		</fo:block-container>
	</xsl:template>



	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Timbre -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<xsl:template match="TED">
		<xsl:variable name="myted" select="." />
		<xsl:variable name="barcode-cfg">
			<barcode>
				<!-- Segun SII, 3cm x 9cm max -->
				<pdf417>
					<module-width>0.008in</module-width>
					<!-- min exigido por Sii 0.0067 -->
					<row-height>3mw</row-height>
					<!-- 3 veces el ancho -->
					<quite-zone enabled="true">0.25in</quite-zone>
					<ec-level>5</ec-level>
					<columns>14</columns>
				</pdf417>
			</barcode>
		</xsl:variable>
		<fo:block-container>

			<fo:block>
				<fo:instream-foreign-object>
					<xsl:copy-of select="tedbarcode:generate($barcode-cfg, $myted)" />
				</fo:instream-foreign-object>
			</fo:block>


			<fo:block font-size="8pt" font-family="sans-serif" text-align="center" language="es" >
				Timbre Electronico SII
			</fo:block>
			<fo:block font-size="8pt" font-family="sans-serif" text-align="center">
				Res. <xsl:value-of select="$resolcode" /> de <xsl:value-of select="$resoldate" /> - Verifique
				Documento en www.sii.cl
			</fo:block>
			<fo:block font-size="3pt" linefeed-treatment="preserve" text-align="center">&#xA;&#xA;&#xA;.</fo:block>
		</fo:block-container>
	</xsl:template>


	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Format -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<xsl:template name="PagoFormat">
		<xsl:param name="medioPago" />
		<xsl:param name="formaPago" />

		<xsl:choose>
			<xsl:when test="$medioPago='CH'">
				Cheque
			</xsl:when>
			<xsl:when test="$medioPago='LT'">
				Letra
			</xsl:when>
			<xsl:when test="$medioPago='EF'">
				Efectivo
			</xsl:when>
			<xsl:when test="$medioPago='PE'">
				Pago a Cta. Corriente
			</xsl:when>
			<xsl:when test="$medioPago='TC'">
				Tarjeta de Crédito
			</xsl:when>
			<xsl:when test="$medioPago='CF'">
				Cheque a Fecha
			</xsl:when>
			<xsl:when test="$medioPago='OT'">
				Otro
			</xsl:when>
		</xsl:choose>

		<xsl:choose>
			<xsl:when test="$formaPago=1">
				(Contado)
			</xsl:when>
			<xsl:when test="$formaPago=2">
				(Crédito)
			</xsl:when>
			<xsl:when test="$formaPago=3">
				(Sin Valor)
			</xsl:when>
		</xsl:choose>

	</xsl:template>

	<xsl:template name="FechaFormat">
		<xsl:param name="fecha" />

		<xsl:value-of select="substring($fecha,string-length($fecha)-1,2)" />
		de
		<xsl:choose>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=01">
				Enero
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=02">
				Febrero
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=03">
				Marzo
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=04">
				Abril
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=05">
				Mayo
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=06">
				Junio
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=07">
				Julio
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=08">
				Agosto
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=09">
				Septiembre
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=10">
				Octubre
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=11">
				Noviembre
			</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=12">
				Diciembre
			</xsl:when>
		</xsl:choose>
		de
		<xsl:value-of select="substring($fecha,string-length($fecha)-9,4)" />
	</xsl:template>

	<xsl:template name="RutFormat">
		<xsl:param name="rut" />
		<xsl:variable name="num" select="substring-before($rut,'-')" />
		<xsl:variable name="dv" select="substring-after($rut,'-')" />
		<xsl:value-of select="substring($num,string-length($num)-8,3)" />.<xsl:value-of select="substring($num,string-length($num)-5,3)" />.<xsl:value-of select="substring($num,string-length($num)-2,3)" />-<xsl:value-of select="$dv" />
	</xsl:template>

</xsl:stylesheet>
