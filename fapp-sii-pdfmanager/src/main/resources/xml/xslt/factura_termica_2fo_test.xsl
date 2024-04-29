<?xml version="1.0" encoding="ISO-8859-1"?>
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
					<fo:region-body margin-top="0cm" margin-bottom="0cm" />
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
					<xsl:value-of select="Encabezado/IdDoc/Folio"/>
				</xsl:with-param>
				<xsl:with-param name="tipo">
					<xsl:value-of select="Encabezado/IdDoc/TipoDTE"/>
				</xsl:with-param>
			</xsl:apply-templates>
			<fo:block font-size="7pt">&#xA0;</fo:block>
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
			<fo:block>
				<fo:table font-weight="normal" font-size="8pt" font-family="monospace" color="black">
					<fo:table-column column-width="60%" />
					<fo:table-column column-width="40%" />
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
					<fo:table-cell text-align="left" border-right-width="0.8pt" border-right-style="solid">
						<fo:block>
							<fo:inline font-weight="bold">Cant.</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell text-align="left" border-right-width="0.8pt" border-right-style="solid" padding-left="0.1cm" padding-right="0.1cm">
						<fo:block>
							<fo:inline font-weight="bold">Detalle</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell text-align="right" border-right-width="0.8pt" border-right-style="solid" padding-left="0.1cm" >
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
			<fo:block>&#xA0;</fo:block>
			<fo:block font-size="0.5pt" color="white">&#xA0;.</fo:block>
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
			<fo:external-graphic content-width="scale-to-fit" text-align="center"
				content-height="scale-to-fit" scaling="uniform" height="2.5cm" width="6.5cm"
				src="{$logo}" />
		</fo:block>
		<fo:block font-weight="bold" font-size="9pt" margin-bottom="0.1cm" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">DATOS DEL EMISOR</fo:block>
		<fo:block font-weight="bold" font-size="8pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">RAZON SOCIAL:
			<!--xsl:value-of select="RznSoc"/-->
			<xsl:call-template name="MayusFormat">
				<xsl:with-param name="palabra">
					<xsl:value-of select="RznSoc"/>
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
						<xsl:value-of select="GiroEmis"/>
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
				<fo:block font-weight="regular" font-size="7pt" font-family="sans-serif" language="es" hyphenate="true" color="black" text-align="left">TELÉFONO:
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
				<fo:instream-foreign-object>
					<xsl:copy-of select="tedbarcode:generate($barcode-cfg, $myted)" />
				</fo:instream-foreign-object>
			</fo:block>
			<fo:block font-size="8pt" font-family="sans-serif" text-align="center" language="es">Timbre Electrónico SII</fo:block>
			<fo:block font-size="8pt" font-family="sans-serif" text-align="center">Res. <xsl:value-of select="$resolcode"/> de <xsl:value-of select="$resoldate"/> - Verifique
		Documento en www.sii.cl</fo:block>
			<fo:block font-size="4pt" linefeed-treatment="preserve" text-align="center">&#xA;&#xA;&#xA;.</fo:block>
			<fo:block font-size="4pt" linefeed-treatment="preserve" text-align="center">&#xA;&#xA;&#xA;.</fo:block>
		</fo:block-container>
	</xsl:template>
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Format -->
	<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
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

	<xsl:template name="FechaCortaFormat">
		<xsl:param name="fechaCorta"/>
		<xsl:value-of select="substring($fechaCorta,string-length($fechaCorta)-1,2)"/>/<xsl:value-of select="substring($fechaCorta,string-length($fechaCorta)-4,2)"/>/<xsl:value-of select="substring($fechaCorta,string-length($fechaCorta)-7,2)"/></xsl:template>
	<xsl:template name="RutFormat">
		<xsl:param name="rut"/>
		<xsl:variable name="num" select="substring-before($rut,'-')"/>
		<xsl:variable name="dv" select="substring-after($rut,'-')"/>
		<xsl:value-of select="substring($num,string-length($num)-8,3)"/>.<xsl:value-of select="substring($num,string-length($num)-5,3)"/>.<xsl:value-of select="substring($num,string-length($num)-2,3)"/>-<xsl:value-of select="$dv"/></xsl:template>
	<xsl:decimal-format name="nacional" grouping-separator="." decimal-separator=","/>
	<xsl:template name="NumFormat">
		<xsl:param name="numero"/>
		<xsl:variable name="numeromiles" select="format-number($numero ,'###.###.###.##0,######','nacional')"/>
		<xsl:value-of select="$numeromiles"/>
	</xsl:template>
	<xsl:template name="MayusFormat">
		<xsl:param name="palabra"/>
		<xsl:variable name="lowercase" select="'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ???'"/>
		<xsl:variable name="uppercase" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞ????'"/>
		<xsl:value-of select="translate($palabra,$lowercase,$uppercase)"/>
	</xsl:template>
</xsl:stylesheet>
