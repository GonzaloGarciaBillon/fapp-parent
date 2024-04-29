<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:tedbarcode="cl.fapp.pdfmanager.xsltextensions.TimbreExtension" extension-element-prefixes="tedbarcode"
                xmlns:barcode="org.krysalis.barcode4j.xalan.BarcodeExt" xmlns:common="http://exslt.org/common" xmlns:xalan="http://xml.apache.org" exclude-result-prefixes="barcode common xalan">

	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>

	<xsl:param name="versionParam" select="'1.0'"/>
	<xsl:param name="logo"/>
	<xsl:param name="resolcode"/>
	<xsl:param name="resoldate"/>


	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

			<fo:layout-master-set>
				<fo:simple-page-master master-name="simple" page-height="27.9cm" page-width="21.6cm" margin-top="1cm" margin-bottom="2cm" margin-left="1cm" margin-right="1cm">
					<fo:region-body margin-top="0cm"/>
					<fo:region-before extent="3cm"/>
					<fo:region-after extent="1.5cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>


			<fo:page-sequence master-reference="simple">
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="DTE/Documento"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>




	<xsl:template match="DTE/Documento">
		<fo:block>
			<fo:table font-size="8pt" font-family="monospace" color="black" space-before="8pt" margin-bottom="1cm">
				<fo:table-column column-width="5cm"/>
				<fo:table-column column-width="8cm"/>
				<fo:table-column column-width="6.0cm"/>
				<!--"21.6cm" -->
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell>
							<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
							<!-- LOGO -->
							<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

							<fo:block margin-left="1cm">
								<fo:external-graphic content-width="scale-to-fit" height="3.5cm" width="3.5cm" text-align="center" content-height="scale-to-fit" scaling="uniform" src="{$logo}"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>

							<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
							<!-- Emisor -->
							<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

							<xsl:apply-templates select="Encabezado/Emisor">
								<xsl:with-param name="folio">
									<xsl:value-of select="Encabezado/IdDoc/Folio"/>
								</xsl:with-param>
								<xsl:with-param name="tipo">
									<xsl:value-of select="Encabezado/IdDoc/TipoDTE"/>
								</xsl:with-param>
							</xsl:apply-templates>
						</fo:table-cell>
						<fo:table-cell>
							<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
							<!-- Recuadro folio -->
							<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
							<fo:block-container display-align="center" text-align="center" max-width="8cm" max-height="4cm" padding="3mm" margin-top="0.5cm" border-color="red" border-style="solid" border-width="0.1cm">
								<fo:block font-size="12px" font-family="Helvetica" color="red" font-style="backslant" font-weight="700" line-height="normal" hyphenate="false">R.U.T.:
									<xsl:call-template name="RutFormat">
										<xsl:with-param name="rut">
											<xsl:value-of select="Encabezado/Emisor/RUTEmisor"/>
										</xsl:with-param>
									</xsl:call-template>
								</fo:block>
								<fo:block font-size="12px" font-family="Helvetica" color="red" font-style="backslant" font-weight="700" line-height="normal" hyphenate="false">
									<xsl:choose>
										<xsl:when test="Encabezado/IdDoc/TipoDTE=39">BOLETA ELECTRONICA</xsl:when>
										<xsl:when test="Encabezado/IdDoc/TipoDTE=33">FACTURA ELECTRONICA</xsl:when>
										<xsl:when test="Encabezado/IdDoc/TipoDTE=52">GUIA DE DESPACHO</xsl:when>
										<xsl:when test="Encabezado/IdDoc/TipoDTE=56">NOTA DE DEBITO</xsl:when>
										<xsl:when test="Encabezado/IdDoc/TipoDTE=61">NOTA DE CREDITO</xsl:when>
										<xsl:otherwise>NO ESTA DEFINIDO</xsl:otherwise>
									</xsl:choose>
								</fo:block>
								<fo:block font-size="12px" font-family="Helvetica" color="red" font-style="backslant" font-weight="700" line-height="normal" hyphenate="false">N&#xB0;	<xsl:value-of select="Encabezado/IdDoc/Folio"/></fo:block>
							</fo:block-container>
							<fo:block-container text-align="center">
								<fo:block font-size="12px" margin-top="3pt" font-family="Helvetica" color="red" font-style="normal" font-weight="700" line-height="normal" hyphenate="false">SII - <xsl:value-of select="Encabezado/Emisor/CmnaOrigen"/></fo:block>
							</fo:block-container>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Fecha y Hora -->
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

			<fo:block>
				<fo:table font-weight="normal" font-size="10pt" font-family="sans-serif" color="black">
					<fo:table-column column-width="40%"/>
					<fo:table-column column-width="60%"/>
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell text-align="left">
								<fo:block>&#xA0;</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="right">
								<fo:block>&#xA0;</fo:block>
							</fo:table-cell>
						</fo:table-row>

						<fo:table-row>
							<fo:table-cell text-align="left" font-weight="bold">
								<fo:block>&#xA0;</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="right" font-weight="bold">
								<fo:block>Fecha de emisión:
									<xsl:call-template name="FechaFormat">
										<xsl:with-param name="fecha">
											<xsl:value-of select="Encabezado/IdDoc/FchEmis"/>
											</xsl:with-param>
									</xsl:call-template>&#xA0;a las <xsl:value-of select="concat(' ', substring(TmstFirma,12,5))"/>&#xA0;hrs.
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
			</fo:block>
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Receptor -->
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

			<fo:table font-family="sans-serif" color="black" text-align="left" space-before="8pt" border-style="solid">
				<fo:table-column column-width="8%"/>
				<fo:table-column column-width="64%"/>
				<fo:table-column column-width="8%"/>
				<fo:table-column column-width="20%"/>
				<fo:table-body>
					<xsl:apply-templates select="Encabezado/Receptor">
						<xsl:with-param name="fecha">
							<xsl:value-of select="Encabezado/IdDoc/FchEmis"/>
						</xsl:with-param>
						<xsl:with-param name="medioPago">
							<xsl:value-of select="Encabezado/IdDoc/MedioPago"/>
						</xsl:with-param>
						<xsl:with-param name="formaPago">
							<xsl:value-of select="Encabezado/IdDoc/FmaPago"/>
						</xsl:with-param>
					</xsl:apply-templates>
				</fo:table-body>
			</fo:table>
			<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Lista Detalle -->
			<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<fo:table font-family="sans-serif" color="black" margin-top="0.5cm">
				<fo:table-column column-width="5%"/>
				<fo:table-column column-width="35%"/>
				<fo:table-column column-width="10%"/>
				<fo:table-column column-width="15%"/>
				<fo:table-column column-width="15%"/>
				<fo:table-column column-width="20%"/>
				<fo:table-header font-size="10px" height="0.5cm" text-align="center">
					<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
						<fo:block>
							<fo:inline font-weight="bold">Item</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
						<fo:block>
							<fo:inline font-weight="bold">Detalle</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
						<fo:block>
							<fo:inline font-weight="bold">Cant.</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
						<fo:block>
							<fo:inline font-weight="bold">P.Unit.</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
						<fo:block>
							<fo:inline font-weight="bold">Dcto.</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
						<fo:block>
							<fo:inline font-weight="bold">Total</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates select="Detalle"/>
				</fo:table-body>
			</fo:table>
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Lista Referencia -->
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<xsl:if test="Referencia">
				<fo:block margin-top="0.5cm" font-weight="bold" font-size="10px" margin-bottom="0.1cm" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">REFERENCIAS:</fo:block>
				<fo:table font-family="sans-serif" color="black" margin-top="0.5cm">
					<fo:table-column column-width="25%"/>
					<fo:table-column column-width="15%"/>
					<fo:table-column column-width="20%"/>
					<fo:table-column column-width="40%"/>

					<fo:table-header font-size="10px" height="0.5cm" text-align="center" background-color="grey">

						<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
							<fo:block>
								<fo:inline font-weight="bold">Documento Ref.</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
							<fo:block>
								<fo:inline font-weight="bold">Folio</fo:inline>
							</fo:block>
						</fo:table-cell>

						<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
							<fo:block>
								<fo:inline font-weight="bold">Fecha Ref.(DD/MM/AA)</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell border-style="solid" padding-top="4pt" padding-bottom="4pt">
							<fo:block>
								<fo:inline font-weight="bold">Razon de Referencia</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-header>
					<fo:table-body>
						<xsl:apply-templates select="Referencia"/>
					</fo:table-body>
				</fo:table>
			</xsl:if>
			<fo:block>
				<fo:table border="1px" margin-bottom="2cm" font-family="sans-serif" border-style="solid" start-indent="60%" margin-top="0.5cm">
					<fo:table-column column-width="40%"/>
					<fo:table-column column-width="5%"/>
					<fo:table-column column-width="55%"/>
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell start-indent="0%" font-size="10px" padding-left="0.1cm">
								<fo:block>
									<fo:inline font-weight="bold">Neto</fo:inline>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell start-indent="0%" font-size="10px" padding-left="0.1cm">
								<fo:block>
									<fo:inline>$:</fo:inline>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell start-indent="0%" font-size="10px" letter-spacing="0pt" padding-left="0.1cm">
								<fo:block>
									<fo:inline>
										<xsl:call-template name="NumFormat">
											<xsl:with-param name="numero">
												<xsl:value-of select="Encabezado/Totales/MntNeto"/>
											</xsl:with-param>
										</xsl:call-template>
										<!--xsl:value-of select="Encabezado/Totales/MntNeto"/-->
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell start-indent="0%" font-size="10px" font-weight="bold" padding-left="0.1cm">
								<fo:block>
									<fo:inline>IVA <xsl:if test="Encabezado/Totales/tasaIVA">%<xsl:value-of select="Encabezado/Totales/TasaIVA"/></xsl:if>19%</fo:inline>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell start-indent="0%" font-size="10px" padding-left="0.1cm">
								<fo:block>
									<fo:inline>$:</fo:inline>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell start-indent="0%" font-size="10px" letter-spacing="0pt" padding-left="0.1cm">
								<fo:block>
									<fo:inline>
										<xsl:call-template name="NumFormat">
											<xsl:with-param name="numero">
												<xsl:value-of select="Encabezado/Totales/IVA"/>
											</xsl:with-param>
										</xsl:call-template>
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell start-indent="0%" font-size="10px" padding-left="0.1cm">
								<fo:block>
									<fo:inline font-weight="bold">Monto Total</fo:inline>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell start-indent="0%" font-size="10px" padding-left="0.1cm">
								<fo:block>
									<fo:inline>$:</fo:inline>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell start-indent="0%" font-size="10px" letter-spacing="0pt" border-bottom-style="solid" padding-left="0.1cm">
								<fo:block>
									<fo:inline>
										<xsl:call-template name="NumFormat">
											<xsl:with-param name="numero">
												<xsl:value-of select="Encabezado/Totales/MntTotal"/>
											</xsl:with-param>
										</xsl:call-template>
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>

			
			</fo:block>
			<xsl:apply-templates select="TED"/>
		</fo:block>
	</xsl:template>
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Llenado de Detalle -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<xsl:template match="Detalle">
		<fo:table-row>
			<fo:table-cell padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<xsl:call-template name="NumFormat">
						<xsl:with-param name="numero">
							<xsl:value-of select="NroLinDet"/>
						</xsl:with-param>
					</xsl:call-template>
					<!--Lo de abajo es para agregar la unidad de medida a la cantidad-->
					<!--xsl:if test="UnmdItem">*<xsl:value-of select="UnmdItem"/></xsl:if-->
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<xsl:value-of select="NmbItem"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<xsl:call-template name="NumFormat">
						<xsl:with-param name="numero">
							<xsl:value-of select="QtyItem"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:if test="UnmdItem">&#xA0;x <xsl:value-of select="UnmdItem"/></xsl:if>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>$<xsl:call-template name="NumFormat">
						<xsl:with-param name="numero">
							<xsl:value-of select="PrcItem"/>
						</xsl:with-param></xsl:call-template></fo:block>
			</fo:table-cell>
			<fo:table-cell padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<xsl:if test="DescuentoPct">%<xsl:value-of select="DescuentoPct"/> | $<xsl:call-template name="NumFormat">
							<xsl:with-param name="numero">
								<xsl:value-of select="DescuentoMonto"/>
							</xsl:with-param></xsl:call-template></xsl:if>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>$<xsl:call-template name="NumFormat">
						<xsl:with-param name="numero">
							<xsl:value-of select="MontoItem"/>
						</xsl:with-param></xsl:call-template></fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Llenado de Referencia -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<xsl:template match="Referencia">
		<fo:table-row>
			<fo:table-cell display-align="center" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<xsl:value-of select="TpoDocRef"/>&#xA0;-
					<xsl:choose>
						<xsl:when test="TpoDocRef=30">Factura</xsl:when>
						<xsl:when test="TpoDocRef=32">Factura de venta bienes y servicios no afectos o exentos de IVA</xsl:when>
						<xsl:when test="TpoDocRef=35">Boleta</xsl:when>
						<xsl:when test="TpoDocRef=38">Boleta exenta</xsl:when>
						<xsl:when test="TpoDocRef=45">Factura de compra</xsl:when>
						<xsl:when test="TpoDocRef=55">Nota de débito</xsl:when>
						<xsl:when test="TpoDocRef=60">Nota de crédito</xsl:when>
						<xsl:when test="TpoDocRef=103">Liquidación</xsl:when>
						<xsl:when test="TpoDocRef=40">Liquidación Factura</xsl:when>
						<xsl:when test="TpoDocRef=43">Liquidación-Factura Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=33">Factura Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=34">Factura No Afecta o Exenta Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=39">Boleta Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=41">Boleta Exenta Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=46">Factura de Compra Electrónica.</xsl:when>
						<xsl:when test="TpoDocRef=56">Nota de Débito Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=61">Nota de Crédito Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=50">Guía de Despacho.</xsl:when>
						<xsl:when test="TpoDocRef=52">Guía de Despacho Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=110">Factura de Exportación Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=111">Nota de Débito de Exportación Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=112">Nota de Crédito de Exportación Electrónica</xsl:when>
						<xsl:when test="TpoDocRef=801">Orden de Compra</xsl:when>
						<xsl:when test="TpoDocRef=802">Nota de pedido</xsl:when>
						<xsl:when test="TpoDocRef=803">Contrato</xsl:when>
						<xsl:when test="TpoDocRef=804">Resolución</xsl:when>
						<xsl:when test="TpoDocRef=805">Proceso ChileCompra</xsl:when>
						<xsl:when test="TpoDocRef=806">Ficha ChileCompra</xsl:when>
						<xsl:when test="TpoDocRef=807">DUS</xsl:when>
						<xsl:when test="TpoDocRef=808">B/L (Conocimiento de embarque)</xsl:when>
						<xsl:when test="TpoDocRef=809">AWB (Air WayBill)</xsl:when>
						<xsl:when test="TpoDocRef=810">MIC/DTA</xsl:when>
						<xsl:when test="TpoDocRef=811">Carta de Porte</xsl:when>
						<xsl:when test="TpoDocRef=812">Resolución del SNA donde califica Servicios de Exportación</xsl:when>
						<xsl:when test="TpoDocRef=813">Pasaporte</xsl:when>
						<xsl:when test="TpoDocRef=814">Certificado de Depósito Bolsa Prod. Chile.</xsl:when>
						<xsl:when test="TpoDocRef=815">Vale de Prenda Bolsa Prod. Chile</xsl:when>
						<xsl:when test="TpoDocRef=820">Código de Inscripción en el Registro de Acuerdos con Plazo de Pago Excepcional</xsl:when>
						<xsl:when test="TpoDocRef=821">Geo Referencia Predio</xsl:when>


						<xsl:otherwise>NO ESTA DEFINIDO</xsl:otherwise>
					</xsl:choose>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center" padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<xsl:value-of select="FolioRef"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center" padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<xsl:call-template name="FechaCortaFormat">
						<xsl:with-param name="fechaCorta">
							<xsl:value-of select="FchRef"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center" padding-top="4pt" font-size="10px" border-style="solid" font-weight="normal" text-align="center" height="0.5cm">
				<fo:block>
					<fo:block>
						<xsl:choose>
							<xsl:when test="CodRef=1">Anula Documento de Referencia</xsl:when>
							<xsl:when test="CodRef=2">Corrige Texto Documento de Referencia</xsl:when>
							<xsl:when test="CodRef=3">Corrige Monto</xsl:when>
							<xsl:otherwise>NO ESTA DEFINIDO</xsl:otherwise>
						</xsl:choose>
						<xsl:if test="string-length(RazonRef) > 0">
						    - <xsl:value-of select="RazonRef"/>
						</xsl:if>
					</fo:block>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="Emisor">
		<xsl:param name="folio"/>
		<xsl:param name="tipo"/>
		<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- Emisor 
		+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!--fo:block font-weight="bold" font-size="12pt" margin-bottom="0.1cm" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">DATOS DEL EMISOR</fo:block-->
		<fo:block-container text-align="left" width="6.3cm" margin-top="0.5cm">
			<fo:block font-weight="bold" font-size="10pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="RznSoc"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<xsl:if test="Sucursal">
				<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">Sucursal:
					SUCURSAL:
					<xsl:value-of select="Sucursal"/>(Codigo SII:
					<xsl:value-of select="CdgSIISucur"/>)</fo:block>
			</xsl:if>
			<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">GIRO:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="GiroEmis"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">DIRECCIÓN:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="DirOrigen"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">COMUNA:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="CmnaOrigen"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">CIUDAD:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="CiudadOrigen"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<xsl:if test="Telefono">
				<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">TELEFONO:
					<xsl:value-of select="Telefono"/>
				</fo:block>
			</xsl:if>
			<xsl:if test="CorreoEmisor">
				<fo:block font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">CORREO:
					<xsl:call-template name="MayusFormat">
						<xsl:with-param name="palabra">
							<xsl:value-of select="CorreoEmisor"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</xsl:if>
		</fo:block-container>
	</xsl:template>



	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Receptor -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Datos del receptor -->
	<xsl:template match="Receptor">
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-top="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">Señor(es):</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-top="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">
					<xsl:call-template name="MayusFormat">
						<xsl:with-param name="palabra">
							<xsl:value-of select="RznSocRecep"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-top="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">RUT:</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-top="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">
					<xsl:call-template name="RutFormat">
						<xsl:with-param name="rut">
							<xsl:value-of select="RUTRecep"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding-top="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">Dirección:</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">
					<xsl:call-template name="MayusFormat">
						<xsl:with-param name="palabra">
							<xsl:value-of select="DirRecep"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">Comuna:</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" font-weight="regular" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">
					<xsl:call-template name="MayusFormat">
						<xsl:with-param name="palabra">
							<xsl:value-of select="CmnaRecep"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-bottom="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">Giro:</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-bottom="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">
					<xsl:call-template name="MayusFormat">
						<xsl:with-param name="palabra">
							<xsl:value-of select="GiroRecep"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-bottom="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">Fono:</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding-top="2pt" margin-bottom="2pt" font-weight="normal" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">
					<xsl:value-of select="Contacto"/>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Timbre -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<xsl:template match="TED">
		<xsl:variable name="myted" select="."/>
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

		<fo:block-container text-align="center">
			<fo:block>
				<!--fo:instream-foreign-object>
					<xsl:copy-of select="tedbarcode:generate($barcode-cfg, $myted)" />
				</fo:instream-foreign-object-->
			</fo:block>


			<fo:block font-size="8pt" font-family="sans-serif" text-align="center">Timbre Electrónico SII</fo:block>
			<fo:block font-size="8pt" font-family="sans-serif" text-align="center">Res.
				<xsl:value-of select="$resolcode"/>de
				<xsl:value-of select="$resoldate"/>- Verifique
				Documento en www.sii.cl</fo:block>
		</fo:block-container>
	</xsl:template>


	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Format -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

	<!-- Función para forma y medio de pago -->
	<xsl:template name="PagoFormat">
		<xsl:param name="medioPago"/>
		<xsl:param name="formaPago"/>
		<xsl:choose>
			<xsl:when test="$medioPago='CH'">Cheque</xsl:when>
			<xsl:when test="$medioPago='LT'">Letra</xsl:when>
			<xsl:when test="$medioPago='EF'">Efectivo</xsl:when>
			<xsl:when test="$medioPago='PE'">Pago a Cta. Corriente</xsl:when>
			<xsl:when test="$medioPago='TC'">Tarjeta de Crédito</xsl:when>
			<xsl:when test="$medioPago='CF'">Cheque a Fecha</xsl:when>
			<xsl:when test="$medioPago='OT'">Otro</xsl:when>
		</xsl:choose>
		<xsl:choose>
			<xsl:when test="$formaPago=1">(Contado)</xsl:when>
			<xsl:when test="$formaPago=2">(Crédito)</xsl:when>
			<xsl:when test="$formaPago=3">(Sin Valor)</xsl:when>
		</xsl:choose>
	</xsl:template>
	<!-- Función para convertir fechas a fechas con meses -->
	<xsl:template name="FechaFormat">
		<xsl:param name="fecha"/>
		<xsl:value-of select="substring($fecha,string-length($fecha)-1,2)"/>&#xA0;de <xsl:choose>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=01">Enero</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=02">Febrero</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=03">Marzo</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=04">Abril</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=05">Mayo</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=06">Junio</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=07">Julio</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=08">Agosto</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=09">Septiembre</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=10">Octubre</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=11">Noviembre</xsl:when>
			<xsl:when test="substring($fecha,string-length($fecha)-4,2)=12">Diciembre</xsl:when></xsl:choose>
		de <xsl:value-of select="substring($fecha,string-length($fecha)-9,4)"/></xsl:template>

	<!-- Función para convertir fecha en fecha corta -->
	<xsl:template name="FechaCortaFormat">
		<xsl:param name="fechaCorta"/>
		<xsl:value-of select="substring($fechaCorta,string-length($fechaCorta)-1,2)"/>/<xsl:value-of select="substring($fechaCorta,string-length($fechaCorta)-4,2)"/>/<xsl:value-of select="substring($fechaCorta,string-length($fechaCorta)-7,2)"/></xsl:template>
	<!-- Función para dar formato a los RUT-->
	<xsl:template name="RutFormat">
		<xsl:param name="rut"/>
		<xsl:variable name="num" select="substring-before($rut,'-')"/>
		<xsl:variable name="dv" select="substring-after($rut,'-')"/>
		<xsl:value-of select="substring($num,string-length($num)-8,3)"/>.<xsl:value-of select="substring($num,string-length($num)-5,3)"/>.<xsl:value-of select="substring($num,string-length($num)-2,3)"/>-<xsl:value-of select="$dv"/></xsl:template>
	<xsl:decimal-format name="nacional" grouping-separator="." decimal-separator=","/>

	<!-- Función para puntuar miles -->
	<xsl:template name="NumFormat">
		<xsl:param name="numero"/>
		<xsl:variable name="numeromiles" select="format-number($numero ,'###.###.###.##0,######','nacional')"/>
		<xsl:value-of select="$numeromiles"/>
	</xsl:template>

	<!-- Función para convertir un minusculas en Mayusculas -->
	<xsl:template name="MayusFormat">
		<xsl:param name="palabra"/>
		<xsl:variable name="lowercase" select="'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ???'"/>
		<xsl:variable name="uppercase" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞ????'"/>
		<xsl:value-of select="translate($palabra,$lowercase,$uppercase)"/>
	</xsl:template>


	<!-- Función para convertir un número a palabras -->
	<xsl:template name="numero-a-palabras">
		<xsl:param name="numero"/>
		<xsl:choose>
			<xsl:when test="$numero = 0">cero</xsl:when>
			<xsl:when test="$numero = 1">un</xsl:when>
			<xsl:when test="$numero = 2">dos</xsl:when>
			<xsl:when test="$numero = 3">tres</xsl:when>
			<xsl:when test="$numero = 4">cuatro</xsl:when>
			<xsl:when test="$numero = 5">cinco</xsl:when>
			<xsl:when test="$numero = 6">seis</xsl:when>
			<xsl:when test="$numero = 7">siete</xsl:when>
			<xsl:when test="$numero = 8">ocho</xsl:when>
			<xsl:when test="$numero = 9">nueve</xsl:when>
			<xsl:when test="$numero = 100">cien</xsl:when>
			<xsl:when test="$numero = 1000">mil</xsl:when>
			<xsl:when test="$numero = 1000000">un millon de</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="$numero &lt; 30">
						<xsl:choose>
							<xsl:when test="$numero = 10">diez</xsl:when>
							<xsl:when test="$numero = 11">once</xsl:when>
							<xsl:when test="$numero = 12">doce</xsl:when>
							<xsl:when test="$numero = 13">trece</xsl:when>
							<xsl:when test="$numero = 14">catorce</xsl:when>
							<xsl:when test="$numero = 15">quince</xsl:when>
							<xsl:when test="$numero &lt; 20">dieci<xsl:call-template name="unidad"><xsl:with-param name="numero" select="$numero mod 10"/></xsl:call-template></xsl:when>
							<xsl:otherwise>
								<xsl:call-template name="decena">
									<xsl:with-param name="numero" select="floor($numero div 10)"/>
								</xsl:call-template>
								<xsl:if test="$numero mod 10 &gt; 0">&#x20;y
									<xsl:call-template name="unidad">
										<xsl:with-param name="numero" select="$numero mod 10"/>
									</xsl:call-template>
								</xsl:if>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:when>
					<xsl:when test="$numero &lt; 100">
						<xsl:call-template name="decena">
							<xsl:with-param name="numero" select="floor($numero div 10)"/>
						</xsl:call-template>
						<xsl:if test="$numero mod 10 &gt; 0">&#x20;y <xsl:call-template name="unidad"><xsl:with-param name="numero" select="$numero mod 10"/></xsl:call-template></xsl:if>
					</xsl:when>
					<xsl:when test="$numero &lt; 1000">
						<xsl:call-template name="centena">
							<xsl:with-param name="numero" select="floor($numero div 100)"/>
						</xsl:call-template>
						<xsl:if test="$numero mod 100 &gt; 0">
							<xsl:call-template name="decenaCentena">
								<xsl:with-param name="numero" select="$numero mod 100"/>&#x20;
							</xsl:call-template>
						</xsl:if>
					</xsl:when>
					<xsl:when test="$numero &lt; 1000000">
						<xsl:call-template name="miles">
							<xsl:with-param name="numero" select="floor($numero div 1000)"/>
						</xsl:call-template>
						<xsl:if test="$numero mod 1000 &gt;= 0">&#x20;mil <xsl:call-template name="miles"><xsl:with-param name="numero" select="$numero mod 1000"/></xsl:call-template></xsl:if>
					</xsl:when>
					<xsl:otherwise>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="decenaCentena">
		<xsl:param name="numero"/>
		<xsl:choose>
			<xsl:when test="$numero &lt; 10">
				<xsl:call-template name="unidad">
					<xsl:with-param name="numero" select="$numero"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="$numero &lt; 30">
				<xsl:choose>
					<xsl:when test="$numero = 10">diez</xsl:when>
					<xsl:when test="$numero = 11">once</xsl:when>
					<xsl:when test="$numero = 12">doce</xsl:when>
					<xsl:when test="$numero = 13">trece</xsl:when>
					<xsl:when test="$numero = 14">catorce</xsl:when>
					<xsl:when test="$numero = 15">quince</xsl:when>
					<xsl:when test="$numero &lt; 20">dieci<xsl:call-template name="unidad"><xsl:with-param name="numero" select="$numero mod 10"/></xsl:call-template></xsl:when>
					<xsl:when test="$numero &lt; 30">veinti<xsl:call-template name="unidad"><xsl:with-param name="numero" select="$numero mod 10"/></xsl:call-template></xsl:when>
					<xsl:otherwise>
						<xsl:call-template name="decena">
							<xsl:with-param name="numero" select="floor($numero div 10)"/>
						</xsl:call-template>
						<xsl:if test="$numero mod 10 &gt; 0">&#x20;y
							<xsl:call-template name="unidad">
								<xsl:with-param name="numero" select="$numero mod 10"/>
							</xsl:call-template>
						</xsl:if>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:when test="$numero &lt; 100">
				<xsl:call-template name="decena">
					<xsl:with-param name="numero" select="floor($numero div 10)"/>
				</xsl:call-template>
				<xsl:if test="$numero mod 10 &gt; 0">&#x20;y <xsl:call-template name="unidad"><xsl:with-param name="numero" select="$numero mod 10"/>&#x20;</xsl:call-template></xsl:if>
			</xsl:when>
			<xsl:when test="$numero &lt; 1000">
				<xsl:call-template name="centena">
					<xsl:with-param name="numero" select="floor($numero div 100)"/>
				</xsl:call-template>
				<xsl:if test="$numero mod 100 &gt; 0">
					<xsl:call-template name="decenaCentena">
						<xsl:with-param name="numero" select="$numero mod 100"/>
					</xsl:call-template>
				</xsl:if>
			</xsl:when>
			<xsl:when test="$numero &lt; 1000000">
				<xsl:call-template name="miles">
					<xsl:with-param name="numero" select="floor($numero div 1000)"/>
				</xsl:call-template>
				<xsl:if test="$numero mod 1000 &gt; 0">
					<xsl:call-template name="miles">&#x20;
						<xsl:with-param name="numero" select="$numero mod 1000"/>
					</xsl:call-template>
				</xsl:if>
			</xsl:when>
		</xsl:choose>
	</xsl:template>

	<!-- Función para convertir unidades -->
	<xsl:template name="unidad">
		<xsl:param name="numero"/>
		<xsl:choose>
			<xsl:when test="$numero = 0"></xsl:when>
			<xsl:when test="$numero = 1">un</xsl:when>
			<xsl:when test="$numero = 2">dos</xsl:when>
			<xsl:when test="$numero = 3">tres</xsl:when>
			<xsl:when test="$numero = 4">cuatro</xsl:when>
			<xsl:when test="$numero = 5">cinco</xsl:when>
			<xsl:when test="$numero = 6">seis</xsl:when>
			<xsl:when test="$numero = 7">siete</xsl:when>
			<xsl:when test="$numero = 8">ocho</xsl:when>
			<xsl:when test="$numero = 9">nueve</xsl:when>
		</xsl:choose>
	</xsl:template>

	<!-- Función para convertir decenas -->
	<xsl:template name="decena">
		<xsl:param name="numero"/>
		<xsl:choose>
			<xsl:when test="$numero = 2">veinti</xsl:when>
			<xsl:when test="$numero = 3">treinta</xsl:when>
			<xsl:when test="$numero = 4">cuarenta</xsl:when>
			<xsl:when test="$numero = 5">cincuenta</xsl:when>
			<xsl:when test="$numero = 6">sesenta</xsl:when>
			<xsl:when test="$numero = 7">setenta</xsl:when>
			<xsl:when test="$numero = 8">ochenta</xsl:when>
			<xsl:when test="$numero = 9">noventa</xsl:when>
			<xsl:otherwise>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- Función para convertir centenas -->
	<xsl:template name="centena">
		<xsl:param name="numero"/>
		<xsl:choose>
			<xsl:when test="$numero = 1">ciento&#x20;</xsl:when>
			<xsl:when test="$numero = 2">doscientos&#x20;</xsl:when>
			<xsl:when test="$numero = 3">trescientos&#x20;</xsl:when>
			<xsl:when test="$numero = 4">cuatrocientos&#x20;</xsl:when>
			<xsl:when test="$numero = 5">quinientos&#x20;</xsl:when>
			<xsl:when test="$numero = 6">seiscientos&#x20;</xsl:when>
			<xsl:when test="$numero = 7">setecientos&#x20;</xsl:when>
			<xsl:when test="$numero = 8">ochocientos&#x20;</xsl:when>
			<xsl:when test="$numero = 9">novecientos&#x20;</xsl:when>
			<xsl:otherwise>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- Función para miles -->
	<xsl:template name="miles">
		<xsl:param name="numero"/>
		<xsl:if test="$numero &gt; 1">
			<xsl:call-template name="numero-a-palabras">
				<xsl:with-param name="numero" select="$numero"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>
