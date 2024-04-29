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
				<fo:simple-page-master master-name="simple" page-width="7.5cm" margin-top="0.5cm" page-height="auto" margin-left="0.5cm" margin-right="0.5cm" margin-bottom="0cm">
					<fo:region-body margin-top="0cm" margin-bottom="0cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>


			<fo:page-sequence master-reference="simple">
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="BOLETADefType/Documento"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="BOLETADefType/Documento">
		<fo:block>
			<xsl:apply-templates select="Encabezado/Emisor">
				<xsl:with-param name="folio">
					<xsl:value-of select="Encabezado/IdDoc/Folio"/>
				</xsl:with-param>
				<xsl:with-param name="tipo">
					<xsl:value-of select="Encabezado/IdDoc/TipoDTE"/>
				</xsl:with-param>
			</xsl:apply-templates>
			<fo:block font-size="7pt">&#xA0;</fo:block>
			<!--xsl:if test="Encabezado/Receptor/RUTRecep!='11111111-1' or '22222222-2' or  '33333333-3' or '44444444-4' or '55555555-5' or '77777777-7' or '88888888-8' or '99999999-9' or '00000000-0'">
				<"11111111-1 or 22222222-2 or  33333333-3 or 44444444-4 
				or 55555555-5 or 77777777-7 or 88888888-8 or 99999999-9 or 00000000-0"/>
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
			</xsl:if-->

			<xsl:choose>
				<xsl:when test="Encabezado/Receptor/RUTRecep='11111111-1'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='22222222-2'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='33333333-3'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='44444444-4'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='55555555-5'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='66666666-6'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='77777777-7'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='88888888-8'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='99999999-9'"></xsl:when>
				<xsl:when test="Encabezado/Receptor/RUTRecep='00000000-0'"></xsl:when>
				<xsl:otherwise>
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
				</xsl:otherwise>
			</xsl:choose>


			<fo:block>
				<fo:table font-weight="normal" font-size="8pt" font-family="monospace" color="black">
					<fo:table-column column-width="60%"/>
					<fo:table-column column-width="40%"/>
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
								<fo:block>Fecha: <xsl:value-of select="concat(' ', substring(TmstFirma,9,2),'/',substring(TmstFirma,6,2),'/',substring(TmstFirma,1,4))"/></fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="right" font-weight="bold">
								<fo:block>&#xA0;Hora: <xsl:value-of select="concat(' ', substring(TmstFirma,12,5))"/></fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
			</fo:block>
			<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Lista Detalle -->
			<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<fo:table font-family="monospace" color="black" text-align="left" space-before="8pt" margin-bottom="0.5cm">
				<fo:table-column column-width="15%"/>
				<fo:table-column column-width="45%"/>
				<fo:table-column column-width="20%"/>
				<fo:table-column column-width="20%"/>
				<fo:table-header font-size="8pt" border-top-width="0.8pt" border-top-style="solid" border-bottom-width="0.8pt" border-bottom-style="solid" height="0.3cm">
					<fo:table-cell text-align="left" border-right-width="0.5pt" border-right-style="solid">
						<fo:block>
							<fo:inline font-weight="bold">Cant.</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell text-align="left" border-right-width="0.5pt" border-right-style="solid" padding-left="0.1cm" padding-right="0.1cm">
						<fo:block>
							<fo:inline font-weight="bold">Detalle</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell text-align="right" border-right-width="0.5pt" border-right-style="solid" padding-left="0.1cm" padding-right="0.1cm">
						<fo:block>
							<fo:inline font-weight="bold">P.Unit.</fo:inline>
						</fo:block>
					</fo:table-cell>

					<fo:table-cell text-align="right" padding-left="0.1cm">
						<fo:block>
							<fo:inline font-weight="bold">Total</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-header>
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell number-columns-spanned="4" border-top-width="0.3pt" border-top-style="solid" height="0.2cm">
							<fo:block/>
						</fo:table-cell>
					</fo:table-row>
					<xsl:apply-templates select="Detalle"/>
					<fo:table-row>
						<fo:table-cell number-columns-spanned="4" border-top-width="0.9pt" border-top-style="solid" height="0.2cm">
							<fo:block/>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell font-size="8pt" text-align="right" number-columns-spanned="3" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline font-weight="bold">Neto $:</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell font-size="8pt" text-align="right" column-number="4" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline font-weight="bold">
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
						<fo:table-cell font-size="8pt" font-weight="bold" number-columns-spanned="3" text-align="right" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline>IVA <xsl:if test="Encabezado/Totales/tasaIVA">%<xsl:value-of select="Encabezado/Totales/TasaIVA"/></xsl:if>19%</fo:inline>$:</fo:block>
						</fo:table-cell>
						<fo:table-cell font-size="8pt" text-align="right" column-number="4" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline font-weight="bold">
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
						<fo:table-cell font-size="8pt" text-align="right" number-columns-spanned="3" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline font-weight="bold">Monto Total $:</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell font-size="8pt" text-align="right" column-number="4" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline font-weight="bold">
									<xsl:call-template name="NumFormat">
										<xsl:with-param name="numero">
											<xsl:value-of select="Encabezado/Totales/MntTotal"/>
										</xsl:with-param>
									</xsl:call-template>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell font-size="8pt" text-align="left" number-columns-spanned="1" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline font-weight="bold">SON:</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell font-size="8pt" text-align="left" column-number="2" number-columns-spanned="3" height="0.5cm" padding-left="0.1cm">
							<fo:block>
								<fo:inline font-weight="bold">
									<xsl:call-template name="MayusFormat">
										<xsl:with-param name="palabra">

											<xsl:call-template name="numero-a-palabras">
												<xsl:with-param name="numero">
													<xsl:value-of select="Encabezado/Totales/MntTotal"/>
												</xsl:with-param>
											</xsl:call-template>
											<xsl:if test="Encabezado/Totales/MntTotal!=1">&#x20;pesos</xsl:if>
											<xsl:if test="Encabezado/Totales/MntTotal=1">&#x20;peso</xsl:if>
										</xsl:with-param>
									</xsl:call-template>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Lista Referencia -->
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<xsl:if test="Referencia">
				<fo:block font-weight="bold" font-size="6pt" margin-bottom="0.1cm" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">REFERENCIAS:</fo:block>
				<fo:table font-size="7pt" font-family="monospace" color="black" font-weight="bold" text-align="left" space-before="8pt" margin-bottom="2cm">
					<fo:table-column column-width="25%"/>
					<fo:table-column column-width="20%"/>
					<fo:table-column column-width="25%"/>
					<fo:table-column column-width="30%"/>

					<fo:table-header font-weight="bold" border-top-width="0.5pt" border-top-style="dotted" border-bottom-width="0.3pt" height="0.3cm">

						<fo:table-cell text-align="left" display-align="center" border-right-width="0.5pt" border-right-style="dotted">
							<fo:block>
								<fo:inline>Referencia</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="center" display-align="center" border-right-width="0.5pt" border-right-style="dotted" padding-left="0.1cm" padding-right="0.1cm">
							<fo:block>
								<fo:inline>Folio</fo:inline>
							</fo:block>
						</fo:table-cell>

						<fo:table-cell text-align="left" display-align="center" border-right-width="0.5pt" border-right-style="dotted" padding-left="0.1cm" padding-right="0.1cm">
							<fo:block>
								<fo:inline>Fecha Ref.(DD/MM/AA)</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" display-align="center" padding-left="0.1cm">
							<fo:block>
								<fo:inline>Razon de Referencia</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-header>
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell number-columns-spanned="4" border-top-width="0.5pt" border-top-style="dotted" height="0.2cm">
								<fo:block/>
							</fo:table-cell>
						</fo:table-row>

						<xsl:apply-templates select="Referencia"/>

						<fo:table-row>
							<fo:table-cell number-columns-spanned="4" border-top-width="0.5pt" border-top-style="dotted" height="0.2cm">
								<fo:block/>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
			</xsl:if>

			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- Inserta TED -->
			<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

			<xsl:apply-templates select="TED"/>
		</fo:block>
	</xsl:template>

	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Llenado de Detalle -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

	<xsl:template match="Detalle">
		<fo:table-row>
			<fo:table-cell font-size="8pt" font-weight="bold" text-align="left" height="0.5cm">
				<fo:block>
					<xsl:call-template name="NumFormat">
						<xsl:with-param name="numero">
							<xsl:value-of select="QtyItem"/>
						</xsl:with-param>
					</xsl:call-template>
					<!--Lo de abajo es para agregar la unidad de medida a la cantidad-->
					<!--xsl:if test="UnmdItem">*<xsl:value-of select="UnmdItem"/></xsl:if-->
				</fo:block>
			</fo:table-cell>
			<fo:table-cell font-size="8pt" font-weight="bold" text-align="left" height="0.5cm" padding-left="0.1cm">
				<fo:block>
					<xsl:value-of select="NmbItem"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell font-size="8pt" font-weight="bold" text-align="right" height="0.5cm" padding-left="0.1cm">
				<fo:block>
					<xsl:call-template name="NumFormat">
						<xsl:with-param name="numero">
							<xsl:value-of select="PrcItem"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell font-size="8pt" font-weight="bold" text-align="right" height="0.5cm" padding-left="0.1cm">
				<fo:block>
					<xsl:call-template name="NumFormat">
						<xsl:with-param name="numero">
							<xsl:value-of select="MontoItem"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Llenado de Referencia -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<xsl:template match="Referencia">
		<fo:table-row>
			<fo:table-cell text-align="left" display-align="center" padding-bottom="0.2cm">
				<fo:block>
					<xsl:value-of select="TpoDocRef"/>-
					<xsl:choose>
						<xsl:when test="TpoDocRef=30">factura</xsl:when>
						<xsl:when test="TpoDocRef=32">factura de venta bienes y servicios no afectos o exentos de IVA</xsl:when>
						<xsl:when test="TpoDocRef=35">Boleta</xsl:when>
						<xsl:when test="TpoDocRef=38">Boleta exenta</xsl:when>
						<xsl:when test="TpoDocRef=45">factura de compra</xsl:when>
						<xsl:when test="TpoDocRef=55">nota de débito</xsl:when>
						<xsl:when test="TpoDocRef=60">nota de crédito</xsl:when>
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
			<fo:table-cell text-align="center" display-align="center" padding-bottom="0.2cm">
				<fo:block>
					<xsl:value-of select="FolioRef"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell text-align="center" display-align="center" padding-bottom="0.2cm">
				<fo:block>
					<xsl:call-template name="FechaCortaFormat">
						<xsl:with-param name="fechaCorta">
							<xsl:value-of select="FchRef"/>
						</xsl:with-param>
					</xsl:call-template>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell text-align="left" display-align="center" padding-bottom="0.2cm">
				<fo:block>
					<fo:block>
						<xsl:choose>
							<xsl:when test="CodRef=1">Anula Documento de Referencia</xsl:when>
							<xsl:when test="CodRef=2">Corrige Texto Documento de Referencia</xsl:when>
							<xsl:when test="CodRef=3">Corrige Monto</xsl:when>
							<xsl:otherwise>NO ESTA DEFINIDO</xsl:otherwise>
						</xsl:choose>
						<xsl:if test="RazonRef">- <xsl:value-of select="RazonRef"/></xsl:if>
					</fo:block>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="Emisor">
		<xsl:param name="folio"/>
		<xsl:param name="tipo"/>
		<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- Recuadro folio 
		+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<fo:block-container width="6.5cm" border-color="black" border-style="solid" border-width="0.8mm" padding="1mm">
			<fo:block font-size="10pt" font-weight="bold" font-family="Courier" color="black" text-align="center" hyphenate="false">R.U.T.: <xsl:call-template name="RutFormat">
					<xsl:with-param name="rut">
						<xsl:value-of select="RUTEmisor"/>
					</xsl:with-param></xsl:call-template></fo:block>
			<fo:block font-size="11pt" font-weight="bold" font-family="Courier" color="black" text-align="center">
				<xsl:choose>
					<xsl:when test="$tipo=39">BOLETA ELECTRONICA</xsl:when>
					<xsl:when test="$tipo=33">FACTURA ELECTRONICA</xsl:when>
					<xsl:when test="$tipo=52">GUIA DE DESPACHO ELECTRONICA</xsl:when>
					<xsl:when test="$tipo=56">NOTA DE DEBITO ELECTRONICA</xsl:when>
					<xsl:when test="$tipo=61">NOTA DE CREDITO ELECTRONICA</xsl:when>
					<xsl:otherwise>NO ESTA DEFINIDO</xsl:otherwise>
				</xsl:choose>
			</fo:block>
			<fo:block font-size="11pt" font-weight="bold" font-family="Courier" color="black" text-align="center">N&#xB0;<xsl:value-of select="$folio"/></fo:block>
		</fo:block-container>
		<fo:block-container>
			<fo:block padding-top="0.3mm" font-size="9pt" font-family="Helvetica" font-weight="bold" color="black" text-align="center" hyphenate="false">SII - <xsl:value-of select="CmnaOrigen"/></fo:block>
		</fo:block-container>
		<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- Emisor 
		+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<fo:block>
			<!--fo:external-graphic
			content-width="scale-to-fit" scaling="uniform" height="2.5cm" width="6.5cm"
			src="{$logo}" /-->
			<!--fo:external-graphic content-width="scale-to-fit" text-align="center" content-height="scale-to-fit" scaling="uniform" height="2.5cm" width="6.5cm" src="{$logo}"/-->
			<fo:external-graphic content-width="scale-to-fit" text-align="center" content-height="scale-to-fit" scaling="uniform" height="2.5cm" width="6.5cm"
			                     src="data:image/png;base64,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"/>
		</fo:block>
		<fo:block font-weight="bold" font-size="9pt" margin-bottom="0.1cm" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">DATOS DEL EMISOR</fo:block>
		<fo:block font-weight="bold" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">RAZON SOCIAL:
			<!--xsl:value-of select="RznSoc"/-->
			<xsl:call-template name="MayusFormat">
				<xsl:with-param name="palabra">
					<xsl:value-of select="RznSocEmisor"/>
				</xsl:with-param>
			</xsl:call-template>
		</fo:block>
		<fo:block-container>
			<xsl:if test="Sucursal">
				<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">Sucursal:
					SUCURSAL:
					<xsl:value-of select="Sucursal"/>(Codigo SII:
					<xsl:value-of select="CdgSIISucur"/>)</fo:block>
			</xsl:if>
			<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">GIRO:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="GiroEmisor"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">DIRECCIÓN:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="DirOrigen"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">COMUNA:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="CmnaOrigen"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">CIUDAD:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="CiudadOrigen"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<xsl:if test="Telefono">
				<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">TELEFONO:
					<xsl:value-of select="Telefono"/>
				</fo:block>
			</xsl:if>
			<xsl:if test="CorreoEmisor">
				<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">CORREO:
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
		<xsl:param name="fecha"/>
		<xsl:param name="medioPago"/>
		<xsl:param name="formaPago"/>
		<fo:block-container>
			<fo:block font-weight="bold" font-size="9pt" margin-bottom="0.1cm" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">DATOS DEL RECEPTOR</fo:block>
			<fo:block font-weight="bold" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">RAZON SOCIAL:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="RznSocRecep"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="normal" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">RUT: <xsl:call-template name="RutFormat">
					<xsl:with-param name="rut">
						<xsl:value-of select="RUTRecep"/>
					</xsl:with-param></xsl:call-template></fo:block>
			<fo:block font-weight="normal" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">GIRO:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="GiroRecep"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">DIRECCIÓN:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="DirRecep"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">COMUNA:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="CmnaRecep"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">CIUDAD:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="CiudadRecep"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
			<fo:block font-weight="normal" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">TELÉFONO: <xsl:value-of select="Contacto"/></fo:block>
			<fo:block font-weight="normal" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">CORREO:
				<xsl:call-template name="MayusFormat">
					<xsl:with-param name="palabra">
						<xsl:value-of select="CorreoRecep"/>
					</xsl:with-param>
				</xsl:call-template>
			</fo:block>
		</fo:block-container>
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
		<fo:block-container>
			<fo:block>
				<!-- fo:instream-foreign-object>
					<xsl:copy-of select="tedbarcode:generate($barcode-cfg, $myted)" />
				</fo:instream-foreign-object -->
			</fo:block>
			<fo:block font-size="8pt" font-family="sans-serif" text-align="center" language="es">Timbre Electronico SII</fo:block>
			<fo:block font-size="8pt" font-family="sans-serif" text-align="center">Res. <xsl:value-of select="$resolcode"/> de <xsl:value-of select="$resoldate"/> - Verifique
		Documento en www.sii.cl</fo:block>
			<fo:block font-size="4pt" linefeed-treatment="preserve" text-align="center">&#xA;&#xA;&#xA;.</fo:block>
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
		<xsl:value-of select="substring($fecha,string-length($fecha)-1,2)"/>de <xsl:choose>
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


	<xsl:template match="NewTemplate">
	</xsl:template>

	<xsl:template match="@xmlns">
	</xsl:template>

	<xsl:template match="SignedInfo">
	</xsl:template>

	<xsl:template match="Signature">
	</xsl:template>

	<xsl:template match="@version">
	</xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2009. Progress Software Corporation. All rights reserved.

<metaInformation>
	<scenarios>
		<scenario default="no" name="Scenario1" userelativepaths="yes" externalpreview="no" url="..\..\..\..\Plantilla billon\segundoXML_33.xml" htmlbaseurl="" outputurl="" processortype="saxon8" useresolver="yes" profilemode="0" profiledepth=""
		          profilelength="" urlprofilexml="" commandline="" additionalpath="" additionalclasspath="" postprocessortype="fop_2" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal"
		          customvalidator="">
			<advancedProp name="bSchemaAware" value="true"/>
			<advancedProp name="xsltVersion" value="2.0"/>
			<advancedProp name="schemaCache" value="||"/>
			<advancedProp name="iWhitespace" value="0"/>
			<advancedProp name="bWarnings" value="true"/>
			<advancedProp name="bXml11" value="false"/>
			<advancedProp name="bUseDTD" value="false"/>
			<advancedProp name="bXsltOneIsOkay" value="true"/>
			<advancedProp name="bTinyTree" value="true"/>
			<advancedProp name="bGenerateByteCode" value="true"/>
			<advancedProp name="bExtensions" value="true"/>
			<advancedProp name="iValidation" value="0"/>
			<advancedProp name="iErrorHandling" value="fatal"/>
			<advancedProp name="sInitialTemplate" value=""/>
			<advancedProp name="sInitialMode" value=""/>
		</scenario>
		<scenario default="yes" name="Boleta" userelativepaths="yes" externalpreview="no" url="boleta_prueba.xml" htmlbaseurl="" outputurl="" processortype="saxon8" useresolver="yes" profilemode="0" profiledepth="" profilelength="" urlprofilexml=""
		          commandline="" additionalpath="" additionalclasspath="" postprocessortype="fop_2" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal" customvalidator="">
			<advancedProp name="bSchemaAware" value="true"/>
			<advancedProp name="xsltVersion" value="2.0"/>
			<advancedProp name="schemaCache" value="||"/>
			<advancedProp name="iWhitespace" value="0"/>
			<advancedProp name="bWarnings" value="true"/>
			<advancedProp name="bXml11" value="false"/>
			<advancedProp name="bUseDTD" value="false"/>
			<advancedProp name="bXsltOneIsOkay" value="true"/>
			<advancedProp name="bTinyTree" value="true"/>
			<advancedProp name="bGenerateByteCode" value="true"/>
			<advancedProp name="bExtensions" value="true"/>
			<advancedProp name="iValidation" value="0"/>
			<advancedProp name="iErrorHandling" value="fatal"/>
			<advancedProp name="sInitialTemplate" value=""/>
			<advancedProp name="sInitialMode" value=""/>
		</scenario>
	</scenarios>
	<MapperMetaTag>
		<MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/>
		<MapperBlockPosition></MapperBlockPosition>
		<TemplateContext></TemplateContext>
		<MapperFilter side="source"></MapperFilter>
	</MapperMetaTag>
</metaInformation>
-->