namespace org.isda.cdm
version "2.52.2"

import cdm.base.*
import cdm.base.datetime.*
import cdm.base.math.*
import cdm.base.staticdata.identifier.*
import cdm.base.staticdata.asset.common.*
import cdm.base.staticdata.party.*
import cdm.synonyms.config.*

type AccessConditions: <"A class to specify each party's election with respect to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.">

	partyElection AccessConditionsElections (2..2) <"The parties' Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA) election.">
	additionalTerminationEvent AdditionalTerminationEvent (0..*) <"Additional Termination Events applicable to the agreement.">
		// [synonym ISDA_Create_1_0 value "additional_termination_event"]

type AccessConditionsElections: <"A class to specify the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_illegality" = "applicable", set to "partyA" when "partyA_illegality" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_illegality" = "applicable", set to "partyB" when "partyB_illegality" = "not_applicable"]
	illegality boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_illegality" = "applicable", set to False when "partyA_illegality" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_illegality" = "applicable", set to False when "partyB_illegality" = "not_applicable"]
	forceMajeure boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_force_majeure" = "applicable", set to False when "partyA_force_majeure" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_force_majeure" = "applicable", set to False when "partyB_force_majeure" = "not_applicable"]
	taxEvent boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_tax_event" = "applicable", set to False when "partyA_tax_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_tax_event" = "applicable", set to False when "partyB_tax_event" = "not_applicable"]
	taxEventUponMerger boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_tax_event_upon_merger" = "applicable", set to False when "partyA_tax_event_upon_merger" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_tax_event_upon_merger" = "applicable", set to False when "partyB_tax_event_upon_merger" = "not_applicable"]
	creditEventUponMerger boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_credit_event_upon_merger" = "applicable", set to False when "partyA_credit_event_upon_merger" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_credit_event_upon_merger" = "applicable", set to False when "partyB_credit_event_upon_merger" = "not_applicable"]

type AdditionalRegime: <"A class to specify the additional regulatory regime(s) that might be elected by the parties to a legal agreement where such provision exists, such as the ISDA 2016 and 2018 CSA for Initial Margin.">

	regime string (1..1) <"The additional regulatory regime as specified by the parties.">
	regimeTerms RegimeTerms (2..2) <"The party elections with respect to the additional regime(s).">
	additionalType AdditionalTypeEnum (0..1) <"The Additional Type of transaction that can require the collection or delivery of initial margin under the specified regulatory regime for the purposes of Covered Transactions, as specified in ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(B).">
	additionalTerms string (0..1) <"The bespoke Additional Type for the purposes of Covered Transactions (IM).">
	//TODO - Condition required that additionalType should exist for 2016 CSD and be absent for 2018 CSD
	//TODO - Condition required that additionalTerms should only exist when additionalType is Other

type AdditionalRepresentation: <"A class to specify the Additional Representation. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (o): Additional Representation(s).">

	partyElection AdditionalRepresentationElection (2..2) <"A qualification as to whether the Additional Representation is applicable.">
	customElection string (0..1) <"A supplemental custom election that might be specified by the parties for the purpose of specifying the Additional Representation.">
		[synonym ISDA_Create_1_0 value "specify"]

type AdditionalRepresentationElection: <"A class to specify the parties' Additional Representation(s) election.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_additional_representations" = "applicable", set to "partyA" when "partyA_additional_representations" = "not_applicable" ]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_additional_representations" = "applicable", set to "partyB" when "partyB_additional_representations" = "not_applicable" ]
	isApplicable boolean (1..1) <"The Additional Representation is applicable when True, and not applicable when False.">
		[synonym ISDA_Create_1_0 set to True when "partyA_additional_representations" = "applicable", set to False when "partyA_additional_representations" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_additional_representations" = "applicable", set to False when "partyB_additional_representations" = "not_applicable"]

type AdditionalRepresentations: <"A class to specify Additional Representations that may be applicable to an agreement.">

	additionalRepresentation AdditionalRepresentation (0..1) <"The specification of the Additional Representation that may be applicable to the agreement.">
		[synonym ISDA_Create_1_0 value "additional_representations"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "10(a)"]
	additionalInformation boolean (0..1) <"The qualification of whether Additional Information related to Regulatory Compliance and Concentration Limits is applicable or not">
		[synonym ISDA_Create_1_0 set to True when "regulatory_compliance_and_concentration_limits->additional_information" = "applicable",
									set to False when "regulatory_compliance_and_concentration_limits->additional_information" = "not_applicable"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "11"]

	condition: one-of

type AdditionalRightsEvent: <"A class to specify the Pledgor/Obligor/Chargor Additional Rights Event election. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (k): Chargor Additional Rights Event. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (k): Obligor Additional Rights Event. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (k): Pledgor Additional Rights Event.">

	isApplicable boolean (1..1) <"The Pledgor Additional Rights Event election is applicable when True, and not applicable when False.">
		[synonym ISDA_Create_1_0 set to True when "applicable" = "true", set to False when "applicable" = "false"]
	qualification string (0..1) <"The qualification of the Pledgor Additional Rights Event election, when specified.">
		[synonym ISDA_Create_1_0 value "specify"]

	condition Qualification: <"The Pledgor/Obligor/Chargor Additional Rights should be qualified only when the Pledgor Additional Rights Event election is specified as applicable.">
		if qualification exists
		then isApplicable = True

type AdditionalTerminationEvent: < "A class to specify an optional termination event, additional to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA)">
	// TODO Never referenced in CDM
	name string (1..1) <"The name of the additional termination event">
		[synonym ISDA_Create_1_0 value "name" path "additional_termination_event"]
		[synonym ISDA_Create_1_0 value "specify" set when "specify" exists]
	applicableParty string (1..2) <"Whether the additional termination event is applicable for the relevant party">
		[synonym ISDA_Create_1_0 set to "PartyA" when "partyA_additional_termination_events" = "applicable"]
		[synonym ISDA_Create_1_0 set to "PartyB" when "partyB_additional_termination_events" = "applicable"]
		[synonym ISDA_Create_1_0 set to "PartyA" when "additional_termination_event->partyA_additional_termination_event" = "applicable"]
		[synonym ISDA_Create_1_0 set to "PartyB" when "additional_termination_event->partyB_additional_termination_event" = "applicable"]

type AdditionalType: <"The specification of the Additional Type of transaction that can require the collection or delivery of initial margin under a given regulatory regime for the purposes of Covered Transactions, as specified in ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(B).">

	standardValue AdditionalTypeEnum (1..1) <"The qualification of the Additional Type of transaction that can require the collection or delivery of initial margin when specified as a standard value.">
		[synonym ISDA_Create_1_0 value "additional_type"]
	customValue string (0..1) <"The qualification of the Additional Type of transaction that can require the collection or delivery of initial margin when specified as a custom value by the parties to the legal agreement.">
		[synonym ISDA_Create_1_0 value "additional_type_specify"]

	condition CustomValue: <"The specification of a custom value by the parties to the legal agreement takes place alongside the qualification of the `Other` value as part of the AdditionalTypeEnum.">
		if standardValue = AdditionalTypeEnum -> Other
		then customValue exists

	condition StandardValue: <"The specification of a standard value by the parties to the legal agreement is done through the qualification of a value distinct than `Other` as part of the AdditionalTypeEnum, and implies that the customerValue is not being qualified.">
		if standardValue <> AdditionalTypeEnum -> Other
		then customValue is absent

type Agreement: <"A class to specify elections specific to a certain type of agreement.">

	creditSupportAgreementElections CreditSupportAgreementElections (0..1) <"Elections to specify an Initial Margin Credit Support Annex or Initial Margin Credit Support Deed.">
		[synonym ISDA_Create_1_0 value "partyA" path "answers" set when "document->documentType" = "Credit Support Annex"]
		[synonym ISDA_Create_1_0 value "partyA" path "answers" set when "document->documentType" = "Credit Support Deed"]
	collateralTransferAgreementElections CollateralTransferAgreementElections (0..1) <"Elections to specify a Collateral Transfer Agreement.">
		[synonym ISDA_Create_1_0 value "partyA" path "answers" set when "document->documentType" = "Collateral Transfer Agreement"]
	securityAgreementElections SecurityAgreementElections (0..1) <"Security agreement elections.">
		[synonym ISDA_Create_1_0 value "partyA" path "answers" set when "document->documentType" = "Security Agreement"]
	transactionConfirmation TransactionConfirmation (0..1) <"A transaction confirmation"> //TODO: Rename Contract and move to here
	condition: one-of

type AgreementTerms: <"A class to specify the elections and variables that characterize a legal agreement.">

	agreement Agreement (1..1) <"The type of contract being specified">
	relatedAgreements RelatedAgreement (0..*) <"Specifies the agreement(s) that govern the agreement, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those agreements, such as the type of agreement, the publisher, the vintage, the agreement identifier and the agreement date.">
	umbrellaAgreement UmbrellaAgreement (0..1) <"The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).">
		[synonym ISDA_Create_1_0 value "umbrella_agreement_and_principal_identification", "umbrella_agreement_and_principal_identification" path "answers->partyA"]

type AmendmentEffectiveDate: <"A class to specify the effective date of the Amendment to Termination Currency. This date can be specified as either an actual date, a specific date (e.g. the annex date) or as a custom provision. ">

	date date (0..1) <"The effective date of the Amendment to Termination Currency when specified as an actual date.">
	specificDate AmendmentEffectiveDateEnum (0..1) <"The effective date of the Amendment to Termination Currency when specified as a specific date (e.g. the annex date).">
		[synonym ISDA_Create_1_0 value "annex_date"]
		[synonym ISDA_Create_1_0 value "effectiveness_date"]
	customProvision string (0..1)<"The effective date of the Amendment to Termination Currency when specified as a non normalized custom provision.">
	condition: one-of

type ApplicableRegime: <"A class to specify the applicable regulatory regime(s) that parties to a legal agreement, such as the ISDA 2016 and 2018 CSA for Initial Margin, might be subject to.">

	regime RegulatoryRegimeEnum (1..1) <"The applicable regulatory regime, as specified through an enumeration.">
		[synonym AcadiaSoft_AM_1_0 value "regime"]
	regimeTerms RegimeTerms (2..2) <"A class that is used by the ApplicableRegime and the AdditionalRegime classes to specify the terms that are specific to each party and regime which are referred to in the Regime Table as part of certain legal agreements, such as such as the ISDA 2016 and 2018 CSA for Initial Margin.">
	additionalType AdditionalTypeEnum (0..1) <"The Additional Type of transaction that can require the collection or delivery of initial margin under the specified regulatory regime for the purposes of Covered Transactions, as specified in ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(B).">
	additionalTerms string (0..1) <"The bespoke Additional Type for the purposes of Covered Transactions (IM).">
	//TODO - Condition required that additionalType should exist for 2016 CSD and be absent for 2018 CSD
	//TODO - Condition required that additionalTerms should only exist when additionalType is Other

type AppropriatedCollateralValuation: <"A class to specify the Valuation of Appropriated Collateral that is applicable to the English Law ISDA CSA. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (u): Valuation of Appropriated Collateral.">

	isSpecified boolean (1..1) <"The qualification of whether the Valuation of Appropriate Collateral provision is applicable (True) or not applicable (False).">
		[synonym ISDA_Create_1_0 set to True when "specified" = "true", set to False when "specified" = "false"]
	election string (0..1) <"The parties' election that qualify the Valuation of Appropriate Collateral in the case where it is deemed applicable.">
		[synonym ISDA_Create_1_0 value "specify"]

	condition Specified: <"The Valuation of Appropriate Collateral election must be specified when it is applicable.">
		if isSpecified = True
		then election exists

	condition NotSpecified: <"The Valuation of Appropriate Collateral election cannot be specified when it is not applicable.">
		if isSpecified = False
		then election is absent

type BespokeCalculationDate: <"A class to specify bespoke Calculation Date terms for the purposes of Initial Margin">

	isApplicable boolean (1..1) <"Additional Calculation Date terms are applicable when True and not applicable when False">
		[synonym ISDA_Create_1_0 set to True when "specified" = "true", set to False when "specified" = "false"]
	calculationDateImTerms string (0..1) <"The Additional Calculation Date terms for the purposes of Initial Margin">

	condition CalculationDateImTerms: <"A data rule to enforce that Additional Calculation Date Terms should be absent when not applicable">
	if isApplicable = False then calculationDateImTerms is absent

type BespokeCalculationTime: <"A class to specify additional Calculation Time terms for the purposes of Initial Margin">

	asCalculationAgentIm boolean (1..1) <"If set to True, the Calculation Time for Initial Margin is the time as of which the Calculation Agent (IM) computes its end of day valuations of derivatives transactions">
		[synonym ISDA_Create_1_0 set to True when "calculation_time_IM_is" = "calculation_agent_IM_computation_time", set to False when "calculation_time_IM_is" = "specify"]
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "specify"]
	bespokeCalculationTimeTerms string (0..1) <"Additional Terms applicable to Calculation Time for Initial Margin">
		[synonym ISDA_Create_1_0 value "calculation_agent_IM_computation_time_specify"]

	condition AsCalculationAgentIm: <"A data rule to enforce that the terms applicable to Calculation Time for Initial Margin should be specified when the computation time is not as per Calculation Agent">
		if asCalculationAgentIm = True
		then bespokeCalculationTimeTerms is absent

	condition BespokeCalculationTimeTerms: <"A data rule to enforce that the Calculation Time for Initial Margin shouldn't be specified when the Control Agreement isn't deemed a Credit Support Document with respect to the party(ies).">
		if asCalculationAgentIm = False
		then bespokeCalculationTimeTerms exists

type BespokeTransferTiming: <"A class to specify any bespoke Transfer Timing language by each party to the agreement.">

	isApplicable boolean (1..1) <"A boolean flag to specify whether bespoke transfer terms are applicable or not.">
		[synonym ISDA_Create_1_0 set to True when "specified" = "true", set to False when "specified" = "false"]
	bespokeTransferTimingTerms string (0..1) <"The bespoke transfer timing terms applicable to the agreement">
		[synonym ISDA_Create_1_0 value "settlement_day_specify"]

type CalculationAgentIm: <"A class to select Calculation Agent for purposes of Initial Margin agreements">

	isApplicable boolean (0..1) <"The specification of whether bespoke calculation agent terms are applicable (True) or not (False)">
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
	party string (0..1) <"The party which is specified as Calculation Agent for Initial Margin.">
		[metadata reference]
		[synonym ISDA_Create_1_0 set to "PartyA" when "calculation_agent" = "partyA"]
		[synonym ISDA_Create_1_0 set to "PartyB" when "calculation_agent" = "party_A"]
		[synonym ISDA_Create_1_0 set to "PartyB" when "calculation_agent" = "partyB"]
		[synonym ISDA_Create_1_0 set to "PartyB" when "calculation_agent" = "party_B"]
		[synonym ISDA_Create_1_0 set to "PartyA,PartyB" when "calculation_agent_IM_party"="demanding_party_and_secured_party"]
	// TODO - Need for a mapping logic that will parse the ISDA Create prefix to identify partyA vs. partyB entries
	calculationAgentTerms string (0..1) <"The Calculation Agent (IM) terms when specified">
		[synonym ISDA_Create_1_0 value "specify"]

	condition CalculationAgentParty: <"A data rule to enforce that party should not be specified when bespoke Calculation Agent Terms exist.">
		if calculationAgentTerms exists then party is absent

	condition CalculationAgentTerms: <"A data rule to enforce that bespoke terms should only be specified when applicable.">
		if isApplicable = True then calculationAgentTerms exists
		else if isApplicable = False then calculationAgentTerms is absent

type CalculationAndTiming: <"A class to specify the Calculation, Valuation and Timing terms specific to the agreement.">

	calculationAgentIm CalculationAgentIm (0..1) <"The calculation agent terms applicable to the agreement.">
		[synonym ISDA_Create_1_0 value "calculation_agent_IM"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "4a"]
	bespokeCalculationDate BespokeCalculationDate (0..1) <"The specification of bespoke Calculation Date terms for the purposes of Initial Margin by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "calculation_date"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "(d)(i)"]
	bespokeCalculationTime BespokeCalculationTime (0..1)	<"Bespoke terms to describe the time as of which such party (or the Calculation Agent (IM) (if applicable)) computes its end of day valuations of derivatives transactions.">
		[synonym ISDA_Create_1_0 value "calculation_time"]
		[synonym ISDA_Create_1_0 value "credit_support_amount_calculation_time"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "4d"]
	calculationDateLocation CalculationDateLocation (0..1) <"The specified location where the credit exposure will be calculated by the respective parties.">
		[synonym ISDA_Create_1_0 value "calculation_date_location"]
		[synonym ISDA_Create_1_0 value "calculation_date"]
<<<<<<< HEAD
		[synonym ISDA_Create_1_0 value "designated_city"]		
=======
		[synonym ISDA_Create_1_0 value "designated_city"]
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "4c"]
	notificationTime NotificationTime (1..1) <"The time by which a demand for the Transfer of Eligible Credit Support (IM) or Posted Credit Support (IM) needs to be made in order for the transfer to take place in accordance with the Transfer Timing provisions.">
		[synonym ISDA_Create_1_0 value "notification_time"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "4e"]
	collateralValuationAgent CollateralValuationAgent (0..1) <"The bespoke Collateral Valuation Agent terms applicable to the agreement.">
		[synonym ISDA_Create_1_0 value "collateral_valuation_agent"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "4b"]
	cashSettlementDay string (0..1) <"Cash Settlement Day has the meaning specified in ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, Paragraph 4(b)(i), unless otherwise specified as part of this attribute. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(iv): Cash Settlement Day.">
		[synonym ISDA_Create_1_0 value "specify" path "cash_settlement_day" set when "cash_settlement_day->specified" = "true"]
	securitiesSettlementDay string (0..1) <"Securities Settlement Day has the meaning specified in ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, Paragraph 12, unless otherwise specified as part of this attribute. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(v): Securities Settlement Day.">
		[synonym ISDA_Create_1_0 value "specify" path "securities_settlement_day" set when "securities_settlement_day->specified" = "true"]

type CalculationCurrencyElection: <"A class to specify the ISDA SIMM Calculation Currency as either the Base Currency or an alternative currency. ISDA 2016 CSA for Initial Margin, Paragraph 13, General Principles (ee)(3). | ISDA 2018 CSA for Initial Margin, Paragraph 13, General Principles (ee)(3).">

	party string (1..1)  <"The party which the SIMM Calculation Currency qualification applies to.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_use_base_currency" = "true", set to "partyA" when "partyA_use_base_currency" = "false"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_use_base_currency" = "true", set to "partyB" when "partyB_use_base_currency" = "false"]
	isBaseCurrency boolean (1..1) <"The SIMM Calculation Currency (also known as SIMM Reporting Currency) means the Base Currency when True. It means a different currency when False. In that latter case, the SIMM Calculation Currency is specified as part of the currency attribute.">
		[synonym ISDA_Create_1_0 set to True when "partyA_use_base_currency" = "true", set to False when "partyA_use_base_currency" = "false"]
		[synonym ISDA_Create_1_0 set to True when "partyB_use_base_currency" = "true", set to False when "partyB_use_base_currency" = "false"]
	currency string (0..1) <"The currency in which the ISDA SIMM Calculation is denominated, when different from the Base Currency. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.">
		[metadata scheme]
		[synonym AcadiaSoft_AM_1_0 value "currency"]
		[synonym ISDA_Create_1_0 value "partyA_use_other_currency"]
		[synonym ISDA_Create_1_0 value "partyB_use_other_currency"]

	condition BaseCurrency: <"A data rule to enforce that, when the SIMM calculation currency is specified as the Base Currency and vice versa">
		if isBaseCurrency = True
		then currency is absent
		else currency exists

type CalculationDateLocation: <"A class to specify the Calculation Date Location election for the respective parties to the legal agreement. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(i): Calculation Date Location. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location.">

	partyElection CalculationDateLocationElection (2..2) <"The parties' calculation date location election.">


type CalculationDateLocationElection: <"A class to specify each of the party elections with respect to the Calculation Date Location. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(i): Calculation Date Location. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_calculation_date_location" = "select_location", set to "partyA" when "partyA_calculation_date_location" = "other"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_calculation_date_location" = "select_location", set to "partyB" when "partyB_calculation_date_location" = "other"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_designated_city" = "select_location", set to "partyA" when "partyA_designated_city" = "other"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_designated_city" = "select_location", set to "partyB" when "partyB_designated_city" = "other"]
	businessCenter BusinessCenterEnum (0..1) <"The Calculation Date Location when specified as a business center which corresponds to the FpML list of business centers or can be mapped to it.">
		[metadata scheme]
		[synonym ISDA_Create_1_0 value "partyA_location"]
		[synonym ISDA_Create_1_0 value "partyB_location"]
	customLocation string (0..1) <"The Calculation Date Location when specified a location which doesn't correspond to the FpML list of business centers or cannot be mapped to it.">
		[synonym ISDA_Create_1_0 value "partyA_specify"]
		[synonym ISDA_Create_1_0 value "partyB_specify"]
<<<<<<< HEAD
	
=======

>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	condition Choice : <"The Calculation Date Location is specified either as a standard business center or as a custom location.">
		required choice businessCenter, customLocation

type CollateralAccessBreach: <"A class to specify Collateral Access Breach language">

	isApplicable boolean (1..1) <"Collateral Access Breach terms are applicable when True and not applicable when False">
		[synonym ISDA_Create_1_0 set to True when "collateral_access_breach" = "applicable", set to False when "collateral_access_breach" = "not_applicable"]
	cabEndDateElection boolean (0..1) <"Determination of whether the Collateral Access Breach end date is a number of days (True) or specified (False)">
		[synonym ISDA_Create_1_0 set to True when "cab_end_date" = "days", set to False when "cab_end_date" = "other"]
	cabEndDate number (0..1) <"The business days following the related Collateral Access Breach when the additional terms end ">
		[synonym ISDA_Create_1_0 value "cab_end_date_days"]
	cabEndDateTerms string (0..1) <"Specific terms for when Collateral Access Breach terms end">
		[synonym ISDA_Create_1_0 value "cab_end_date_specify"]

	condition CabEndDateTerms: <"A condition to require Collateral Access Breach End Date Terms when a specification is required">
		if cabEndDateElection = True then cabEndDateTerms is absent

	// condition CabEndDate: <"A condition to enforce that Collateral Access Breach terms should be absent when Not Applicable">
	// 	if isApplicable = False then cabEndDateElection and cabEndDate and cabEndDateTerms is absent

//TODO - Condition required cabEndDate OR cabEndDateTerms required if CollateralAccessBreach is applicable

type CollateralManagementAgreement: <"A class to specify the Collateral Management Agreement election by the respective parties to a Japanese Law ISDA CSA. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(i): Collateral Management Agreement.">

	partyElection CollateralManagementAgreementElection (2..2) <"The parties' Collateral Management Agreement election.">

type CollateralManagementAgreementElection: <"A class to specify the Collateral Management Agreement election by each party as the Obligee. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b(i): Collateral Management Agreement.">

	party Party (1..1) <"The elective party.">
		[metadata reference]
	// TODO - Need for a mapping logic that will parse the ISDA Create prefix to identify partyA vs. partyB entries
	collateralManagementAgreement string (1..1) <"The designated Collateral Management Agreement with respect to the elective party as the Obligee.">
		[synonym ISDA_Create_1_0 value "partyA_specify", "partyB_specify"]

type CollateralRounding: <"A class to specify the rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(C): Rounding. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding.">

	deliveryAmount number (1..1) <"The rounding methodology applicable to the Delivery Amount in terms of nearest integral multiple of Base Currency units.">
		[synonym ISDA_Create_1_0 value "delivery_amount"]
	returnAmount number (1..1) <"The rounding methodology applicable to the Return Amount in terms of nearest integral multiple of Base Currency units.">
		[synonym ISDA_Create_1_0 value "return_amount"]

type CollateralTransferAgreementElections: <"The set of elections which specify a Collateral Transfer Agreement">

	regime Regime (1..1) <"The Regime Table provision , which determines the regulatory regime(s) applicable to each of the parties to the agreement.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "Regimes"]
	oneWayProvisions OneWayProvisions (1..1) <"The determination of whether the One Way Provisions are applicable (true) or not applicable (false).">
		[synonym ISDA_Create_1_0 value "one_way_provisions"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (a)"]
	generalSimmElections GeneralSimmElections (1..1) <"The specification of the ISDA SIMM Method for all Covered Transactions with respect to all Regimes.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (e)"]
	identifiedCrossCurrencySwap boolean (0..1) <"The qualification of whether cross-currency swaps need to be identified in the Confirmation so that the obligations to exchange principal be disregarded for the purpose of determining the Delivery Amount or Return Amount.">
		[synonym ISDA_Create_1_0 set to True when "cross_currency_swap->yey_ney" = "true", set to False when "cross_currency_swap->yey_ney" = "false"]
<<<<<<< HEAD
	// [documentReference Euroclear CtaInitialMargin 2018 paragraph "13" section "(g)"]	
	sensitivityMethodologies SensitivityMethodologies (1..1) <"The specification of methodologies to compute sensitivities specific to the agreement.">
	fxHaircutCurrency FxHaircutCurrency (0..1) <"The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.">
		[synonym ISDA_Create_1_0 value "fx_haircut_percentage"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "(h)"]		
=======
	// [documentReference Euroclear CtaInitialMargin 2018 paragraph "13" section "(g)"]
	sensitivityMethodologies SensitivityMethodologies (1..1) <"The specification of methodologies to compute sensitivities specific to the agreement.">
	fxHaircutCurrency FxHaircutCurrency (0..1) <"The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.">
		[synonym ISDA_Create_1_0 value "fx_haircut_percentage"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "(h)"]
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	postingObligations PostingObligations (1..1) <"The security providers posting obligations.">
		[synonym ISDA_Create_1_0 value "security_provider_posting_obligations"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "General Principles (ii)"]
	substitutedRegime SubstitutedRegime (1..1) <"The specification of Additional regimes for purposes of determining whether a Regulatory Event has occurred.">
		[synonym ISDA_Create_1_0 value "substituted_regimes"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (k)"]
	baseCurrency string (1..1) <"The base currency for the document as elected by the parties to the agreement. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.">
		[metadata scheme]
		[synonym ISDA_Create_1_0 value "currency" path "base_currency"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "1"]
	creditSupportObligations CreditSupportObligationsInitialMargin (1..1) <"The Credit Support Obligations applicable to the agreement. ">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "3"]
	calculationAndTiming CalculationAndTiming (1..1) <"The set of elections for determining Valuation and Timing terms specific to the agreement">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "4"]
	conditionsPrecedent ConditionsPrecedent (1..1) <"The set of elections that may overwrite the default Condition Precedent provision, and the set of provisions that are deemed Access Condition.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "5"]
	substitution Substitution (1..1) <"The conditions under which the Security Provider can substitute posted collateral.">
		[synonym ISDA_Create_1_0 value "consent"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "f"]
	disputeResolution DisputeResolution (1..1) <"The election terms under which a party disputes (i) the Calculation Agent’s calculation of a Delivery Amount or a Return Amount, or (ii) the Value of any Transfer of Eligible Credit Support or Posted Credit Support.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "6"]
	rightsEvents RightsEvents (1..1) <"The bespoke provisions that might be specified by the parties to the agreement to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred..">
	custodyArrangements CustodyArrangements (1..1) <"The Custodian and Segregated Account details in respect of each party to the agreement.">
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "m"]
	additionalRepresentations AdditionalRepresentations (1..1) <"The specification Additional Representations that may be applicable to the agreement.">
	demandsAndNotices ContactElection (0..1) <"The optional specification of address where the demands, specifications and notices will be communicated to for each of the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "demands_and_notices"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "12"]
	addressesForTransfer ContactElection (0..1) <"The optional specification of address for transfer as specified by the respective parties to the agreement.">
		[synonym ISDA_Create_1_0 value "addresses_for_transfers"]
<<<<<<< HEAD
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "12"]		
	otherCsa string (0..1) <"The bespoke definition of Other CSA as specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "other_csa->specify" set when "other_csa->specified" = "true"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "13"]		
=======
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "12"]
	otherCsa string (0..1) <"The bespoke definition of Other CSA as specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "other_csa->specify" set when "other_csa->specified" = "true"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "13"]
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	terminationCurrencyAmendment TerminationCurrencyAmendment (1..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Termination Currency.  Unless specified the definition of Termination Currency has the meaning specified in the Schedule to the ISDA Master Agreement.">
		[synonym ISDA_Create_1_0 value "amendment_to_termination_currency"]
		[synonym ISDA_Create_1_0 value "security_provider_posting_obligations"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "13"]
<<<<<<< HEAD
	minimumTransferAmountAmendment MinimumTransferAmountAmendment (1..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Minimum Transfer Amount.  Unless specified the definition of Minimum Transfer Amount in any Other Regulatory CSA has the meaning specified in such Other Regulatory CSA.">	
=======
	minimumTransferAmountAmendment MinimumTransferAmountAmendment (1..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Minimum Transfer Amount.  Unless specified the definition of Minimum Transfer Amount in any Other Regulatory CSA has the meaning specified in such Other Regulatory CSA.">
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
		[synonym ISDA_Create_1_0 value "amendment_to_minimum_transfer_amount" mapper "MinimumTransferAmountAmendment"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "14"]
	interpretationTerms string (0..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Interpretations.">
		[synonym ISDA_Create_1_0 value "paragraph_1_6a_specify" path "interpretation" set when "interpretation->paragraph_1_6a_is" = "specify"]
		[synonym ISDA_Create_1_0 value "paragraph_10ki_specify" path "interpretation" set when "interpretation->paragraph_10ki_is" = "specify"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "15"]
	processAgent ProcessAgent (0..1) <"The Process Agent that might be appointed by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "process_agent"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "16"]
	jurisdictionRelatedTerms JurisdictionRelatedTerms (0..1) <"The jurisdiction specific terms relevant to the agreement.">
	additionalAmendments string (0..1) <"Any additional amendments that might be specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "specify" path "amendments" maps 2 set when "amendments->is_applicable" = "applicable"] // TODO: remove "maps 2" once migration complete
	additionalBespokeTerms string (0..1) <"Any additional terms that might be specified applicable.">
		[synonym ISDA_Create_1_0 value "specify" path "additional_terms" set when "additional_terms->is_applicable" = "applicable"]
		[synonym ISDA_Create_1_0 value "specify" path "bespoke_provisions" set when "bespoke_provisions->is_applicable" = "applicable"]

type CollateralValuationAgent: <"A class to specify Collateral Valuation Agent terms.">

	partyElection CollateralValuationAgentElection (0..2) <"The parties Collateral Valuation Agent Elections.">

type CollateralValuationAgentElection: <"A class to specify Collateral Valuation Agent language.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_collateral_valuation_agent" = "other"] //Check synonyms
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_collateral_valuation_agent" = "other"] //Check synonyms
	additionalLanguage string (0..1) <"The additional language that might be specified by the parties to the legal agreement.">
		[synonym ISDA_Create_1_0 value "partyA_specify"] //Check synonyms
		[synonym ISDA_Create_1_0 value "partyB_specify"] //Check synonyms

type ConditionsPrecedent: <"A class to specify the two set of elections that may overwrite the default Condition Precedent provision as specified in Paragraph 4, (a) of the ISDA 2016 Credit Support Annex for Initial Margin and the ISDA 2016 Credit Support Annex for Variation Margin. | ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2018 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f): Conditions Precedent. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.">

	conditionsPrecedentElection boolean (0..1) <"The election to specify whether the standard Conditions Precedent apply">
		[synonym ISDA_Create_1_0 set to True when "conditions_precedent->conditions_precedent" = "not specified", set to False when "conditions_precedent->conditions_precedent" = "paragraph_3_1_will_not_apply"]
		[synonym ISDA_Create_1_0 set to True when "conditions_precedent->specified" = "false", set to False when "conditions_precedent->specified" = "true"]
	customProvision string (0..1) <"The custom provisions that might be specified by the parties to the agreement for the purpose of overwriting the default Condition Precedent provision as specified in ISDA 2016 Credit Support Annex for Initial Margin and the ISDA 2016 Credit Support Annex for Variation Margin, Paragraph 4, (a). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(i). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(i). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(i). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, : Conditions Precedent and Secured Party’s Rights and Remedies.">
		[synonym ISDA_Create_1_0 value "specify" path "conditions_precedent"]
	accessConditions AccessConditions (1..1) <"The parties' election with respect to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.">
		[synonym ISDA_Create_1_0 value "access_conditions"] //"conditions_precedent"
		[synonym ISDA_Create_1_0 value "access_conditions" path "conditions_precedent"]

	condition CustomProvision: <"When a Custom Provision is specified then the Conditions Precedent Election should be absent.">
		if customProvision exists
		then conditionsPrecedentElection = False

type ContactElection: <"A class to specify the parties' election to specify contact information, in relation to elections such as the Addresses for Transfer or the Demand and Notices as specified in the ISDA Credit Support Annex agreement.">

	partyElection PartyContactInformation (2..2 ) <"The parties' contact information election.">

type ControlAgreement: <"A class to specify the relationship between the Control Agreement and the Credit Support Agreement.">

	partyElection ControlAgreementElections (2..2) <"The party specific elections.">

type ControlAgreementElections: <"A class to specify the Control Agreement election sby each party to the agreement.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "control_agreement_as_a_credit_support_document->partyA_control_agreement_as_a_credit_support_document" = "yes",
									set to "partyA" when "control_agreement_as_a_credit_support_document->partyA_control_agreement_as_a_credit_support_document" = "no"]
		[synonym ISDA_Create_1_0 set to "partyB" when "control_agreement_as_a_credit_support_document->partyB_control_agreement_as_a_credit_support_document" = "yes",
									set to "partyB" when "control_agreement_as_a_credit_support_document->partyB_control_agreement_as_a_credit_support_document" = "no"]
		[synonym ISDA_Create_1_0 set to "partyA" when "euroclear_agreements_as_credit_support_documents->partyA_euroclear_agreements_as_credit_support_documents" = "yes",
									set to "partyA" when "euroclear_agreements_as_credit_support_documents->partyA_euroclear_agreements_as_credit_support_documents" = "no"]
		[synonym ISDA_Create_1_0 set to "partyB" when "euroclear_agreements_as_credit_support_documents->partyB_euroclear_agreements_as_credit_support_documents" = "yes",
									set to "partyB" when "euroclear_agreements_as_credit_support_documents->partyB_euroclear_agreements_as_credit_support_documents" = "no"]
		[synonym ISDA_Create_1_0 set to "partyA" when "clearstream_agreements_as_credit_support_documents->partyA_clearstream_agreements_as_credit_support_documents" = "yes",
									set to "partyA" when "clearstream_agreements_as_credit_support_documents->partyA_clearstream_agreements_as_credit_support_documents" = "no"]
		[synonym ISDA_Create_1_0 set to "partyB" when "clearstream_agreements_as_credit_support_documents->partyB_clearstream_agreements_as_credit_support_documents" = "yes",
									set to "partyB" when "clearstream_agreements_as_credit_support_documents->partyB_clearstream_agreements_as_credit_support_documents" = "no"]
	controlAgreementAsCsd boolean (1..1) <"The identification of whether the Control Agreement is a Credit Support Document with respect to each party">
		[synonym ISDA_Create_1_0 set to True when "control_agreement_as_a_credit_support_document->partyA_control_agreement_as_a_credit_support_document" = "yes",
									set to False when "control_agreement_as_a_credit_support_document->partyA_control_agreement_as_a_credit_support_document" = "no"]
		[synonym ISDA_Create_1_0 set to True when "control_agreement_as_a_credit_support_document->partyB_control_agreement_as_a_credit_support_document" = "yes",
									set to False when "control_agreement_as_a_credit_support_document->partyB_control_agreement_as_a_credit_support_document" = "no"]
		[synonym ISDA_Create_1_0 set to True when "euroclear_agreements_as_credit_support_documents->partyA_euroclear_agreements_as_credit_support_documents" = "yes",
									set to False when "euroclear_agreements_as_credit_support_documents->partyA_euroclear_agreements_as_credit_support_documents" = "no"]
		[synonym ISDA_Create_1_0 set to True when "euroclear_agreements_as_credit_support_documents->partyB_euroclear_agreements_as_credit_support_documents" = "yes",
									set to False when "euroclear_agreements_as_credit_support_documents->partyB_euroclear_agreements_as_credit_support_documents" = "no"]
		[synonym ISDA_Create_1_0 set to True when "clearstream_agreements_as_credit_support_documents->partyA_clearstream_agreements_as_credit_support_documents" = "yes",
									set to False when "clearstream_agreements_as_credit_support_documents->partyA_clearstream_agreements_as_credit_support_documents" = "no"]
		[synonym ISDA_Create_1_0 set to True when "clearstream_agreements_as_credit_support_documents->partyB_clearstream_agreements_as_credit_support_documents" = "yes",
									set to False when "clearstream_agreements_as_credit_support_documents->partyB_clearstream_agreements_as_credit_support_documents" = "no"]
	// TODO - add Condition - include when 2018 CSD English Law, exclude when 2016 (captured under CustodyArrangements)
	consistencyWithControlAgreement boolean (0..1) <"Unless specified as inapplicable in the event of any inconsistency between this Deed and the Control Agreement, this Deed will prevail over the Control Agreement">
		[synonym ISDA_Create_1_0 set to True when "inconsistency_with_the_control_agreement->partyA_inconsistency_with_the_control_agreement" = "applicable",
									set to False when "inconsistency_with_the_control_agreement->partyA_inconsistency_with_the_control_agreement" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "inconsistency_with_the_control_agreement->partyB_inconsistency_with_the_control_agreement" = "applicable",
									set to False when "inconsistency_with_the_control_agreement->partyB_inconsistency_with_the_control_agreement" = "not_applicable"]
	// TODO - add Condition - only include when 2018 CSD English Law
	relationshipWithControlAgreement boolean (0..1) <"Unless specified as inapplicable the parties recognise that the Control Agreement is a means by which the parties can perform their obligations.">
		[synonym ISDA_Create_1_0 set to True when "relationship_with_the_control_agreement->partyA_control_agreement_relationship" = "applicable",
									set to False when "relationship_with_the_control_agreement->partyA_control_agreement_relationship" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "relationship_with_the_control_agreement->partyB_control_agreement_relationship" = "applicable",
									set to False when "relationship_with_the_control_agreement->partyB_control_agreement_relationship" = "not_applicable"]
	// TODO - add Condition - only include when 2018 CSD English Law

type ControlAgreementNecEvent: <"A class to specify Control Agreement language related to delivery of a Notice of Exclusive Control">

	controlAgreementNecEventElection ControlAgreementNecEventElection (2..2)

type ControlAgreementNecEventElection: <"A class to specify party specific Control Agreement language related to delivery of a Notice of Exclusive Control">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_control_agreement_nec_event" = "applicable", set to "partyA" when "partyA_control_agreement_nec_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyB_control_agreement_nec_event" = "applicable", set to "partyB" when "partyB_control_agreement_nec_event" = "not_applicable"]

	necEvent boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_control_agreement_nec_event" = "applicable", set to False when "partyA_control_agreement_nec_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_control_agreement_nec_event" = "applicable", set to False when "partyB_control_agreement_nec_event" = "not_applicable"]

type CreditNotation: <"A class to specify the credit notation as the combination of agency, notation, scale and debt type qualifications.">
	[synonym FpML_5_10 value "CreditNotation"]

	agency CreditRatingAgencyEnum (1..1) <"The credit agency to which the other variables (notation, scale, debt type) refer to.">
		[metadata scheme]
		[synonym FpML_5_10 value "agency" meta "creditRatingAgencyScheme"]
	notation string (1..1) <"The credit rating notation. As it varies among credit rating agencies, FpML doesn't specify a default scheme.">
		[metadata scheme]
		[synonym FpML_5_10 value "notation" meta "creditRatingNotationScheme"]
	scale string (0..1) <"The credit rating scale, with a typical distinction between short term, long term. FpML doesn't specify a default scheme, which is hence not specified as an enumeration as part of the CDM.">
		[metadata scheme]
		[synonym FpML_5_10 value "scale" meta "creditRatingScaleScheme"]
	debt CreditRatingDebt (0..1) <"The credit rating debt type (e.g. long term, high yield, deposits, ...) associated with the credit rating notation and scale.">
		[synonym FpML_5_10 value "debt"]


type CreditNotations: <"The credit rating notation higher level construct, which provides the ability to specify multiple rating notations.">
	[synonym FpML_5_10 value "CreditNotations"]

	creditNotation CreditNotation (0..1) <"This attribute is specified when only one credit notation is determined.">
		[synonym FpML_5_10 value "creditNotation"]
	creditNotations MultipleCreditNotations (0..1) <"This attribute provides the ability to specify several credit notations, alongside an 'any' or 'all' or all condition.">
	condition: one-of

type CreditRatingDebt: <"The credit rating debt type(s) associated with the credit rating notation and scale. When several debt types are specified, they must be qualified through an 'any' or 'all'.">
	[synonym FpML_5_10 value "CreditRatingDebt"]

	debtType string (0..1) <"This attribute is to be specified when only one debt type is specified. FpML doesn't specify values in relation to the associated scheme, which is hence not specified as an enumeration as part of the CDM.">
		[metadata scheme]
		[synonym FpML_5_10 value "debtType" meta "debtTypeScheme"]
	debtTypes MultipleDebtTypes (0..1) <"This attribute provides the ability to specify several debt types, alongside an 'any' or 'all' or all condition. As an example, Baa1 rating is required for any long term debt and deposit.">
	condition: one-of

type CreditSupportAgreementElections: <"The set of elections which specify a Credit Support Annex or Deed.">

	regime Regime (1..1) <"The Regime Table provision , which determines the regulatory regime(s) applicable to each of the parties to the agreement.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "Regimes"]
	oneWayProvisions OneWayProvisions (1..1) <"The determination of whether the One Way Provisions are applicable (true) or not applicable (false).">
		[synonym ISDA_Create_1_0 value "one_way_provisions"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (a)"]
	generalSimmElections GeneralSimmElections (1..1) <"The specification of the ISDA SIMM Method for all Covered Transactions with respect to all Regimes.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (e)"]
	identifiedCrossCurrencySwap boolean (0..1) <"The qualification of whether cross-currency swaps need to be identified in the Confirmation so that the obligations to exchange principal be disregarded for the purpose of determining the Delivery Amount or Return Amount.">
		[synonym ISDA_Create_1_0 set to True when "cross_currency_swap->yey_ney" = "true", set to False when "cross_currency_swap->yey_ney" = "false"]
<<<<<<< HEAD
	// [documentReference Euroclear CtaInitialMargin 2018 paragraph "13" section "(g)"]	
	sensitivityMethodologies SensitivityMethodologies (1..1) <"The specification of methodologies to compute sensitivities specific to the agreement.">
	fxHaircutCurrency FxHaircutCurrency (0..1) <"The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.">
		[synonym ISDA_Create_1_0 value "fx_haircut_percentage"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "(h)"]		
=======
	// [documentReference Euroclear CtaInitialMargin 2018 paragraph "13" section "(g)"]
	sensitivityMethodologies SensitivityMethodologies (1..1) <"The specification of methodologies to compute sensitivities specific to the agreement.">
	fxHaircutCurrency FxHaircutCurrency (0..1) <"The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.">
		[synonym ISDA_Create_1_0 value "fx_haircut_percentage"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "(h)"]
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	postingObligations PostingObligations (1..1) <"The security providers posting obligations.">
		[synonym ISDA_Create_1_0 value "chargor_posting_obligations"]
		[synonym ISDA_Create_1_0 value "pledgor_posting_obligations"]
		[synonym ISDA_Create_1_0 value "obligor_posting_obligations"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "General Principles (ii)"]
	substitutedRegime SubstitutedRegime (1..1) <"The specification of Additional regimes for purposes of determining whether a Regulatory Event has occurred.">
		[synonym ISDA_Create_1_0 value "substituted_regimes"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (k)"]
	baseCurrency string (1..1) <"The base currency for the document as elected by the parties to the agreement. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.">
		[metadata scheme]
		[synonym ISDA_Create_1_0 value "currency" path "base_currency"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "1"]
	additionalObligations string (0..1) <"The additional obligations that might be specified by the parties to a Credit Support Agreement.">
		[synonym ISDA_Create_1_0 value "additional_obligations_specify" path "additional_obligations" set when "additional_obligations->additional_obligations" = "specify"]
	creditSupportObligations CreditSupportObligationsInitialMargin (1..1) <"The Credit Support Obligations applicable to the agreement. ">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "3"]
	calculationAndTiming CalculationAndTiming (1..1) <"The set of elections for determining Valuation and Timing terms specific to the agreement">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "4"]
	conditionsPrecedent ConditionsPrecedent (1..1) <"The set of elections that may overwrite the default Condition Precedent provision, and the set of provisions that are deemed Access Condition.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "5"]
	substitution Substitution (1..1) <"The conditions under which the Security Provider can substitute posted collateral.">
		[synonym ISDA_Create_1_0 value "consent"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "f"]
	disputeResolution DisputeResolution (1..1) <"The election terms under which a party disputes (i) the Calculation Agent’s calculation of a Delivery Amount or a Return Amount, or (ii) the Value of any Transfer of Eligible Credit Support or Posted Credit Support.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "6"]
	rightsEvents RightsEvents (1..1) <"The bespoke provisions that might be specified by the parties to the agreement to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred..">
	custodyArrangements CustodyArrangements (1..1) <"The Custodian and Segregated Account details in respect of each party to the agreement.">
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "m"]
	additionalRepresentations AdditionalRepresentations (1..1) <"The specification Additional Representations that may be applicable to the agreement.">
	otherEligibleAndPostedSupport OtherEligibleAndPostedSupport (1..1) <"The Other Eligible Support elections associated with margin agreements.">
	demandsAndNotices ContactElection (0..1) <"The optional specification of address where the demands, specifications and notices will be communicated to for each of the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "demands_and_notices"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "12"]
	addressesForTransfer ContactElection (0..1) <"The optional specification of address for transfer as specified by the respective parties to the agreement.">
		[synonym ISDA_Create_1_0 value "addresses_for_transfers"]
<<<<<<< HEAD
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "12"]		
	otherCsa OtherAgreements (0..1) <"The bespoke definition of Other CSA as specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "other_csa"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "13"]		
=======
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "12"]
	otherCsa OtherAgreements (0..1) <"The bespoke definition of Other CSA as specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "other_csa"]
	// [documentReference Euroclear CtaInitialMargin 2018 English Law paragraph "13" section "13"]
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	japaneseLawCsa OtherAgreements (0..1) <"The bespoke definition of whether Japanese Law CSA (VM) are specified by the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (s)(ii): Japanese Law CSA (VM).">
		[synonym ISDA_Create_1_0 value "japanese_law_csa_vm"]
	terminationCurrencyAmendment TerminationCurrencyAmendment (1..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Termination Currency.  Unless specified the definition of Termination Currency has the meaning specified in the Schedule to the ISDA Master Agreement.">
		[synonym ISDA_Create_1_0 value "amendment_to_termination_currency"]
		[synonym ISDA_Create_1_0 value "pledgor_posting_obligations"]
		[synonym ISDA_Create_1_0 value "chargor_posting_obligations"]
		[synonym ISDA_Create_1_0 value "obligor_posting_obligations"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "13"]
<<<<<<< HEAD
	minimumTransferAmountAmendment MinimumTransferAmountAmendment (1..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Minimum Transfer Amount.  Unless specified the definition of Minimum Transfer Amount in any Other Regulatory CSA has the meaning specified in such Other Regulatory CSA.">	
=======
	minimumTransferAmountAmendment MinimumTransferAmountAmendment (1..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Minimum Transfer Amount.  Unless specified the definition of Minimum Transfer Amount in any Other Regulatory CSA has the meaning specified in such Other Regulatory CSA.">
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
		[synonym ISDA_Create_1_0 value "amendment_to_minimum_transfer_amount" mapper "MinimumTransferAmountAmendment"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "14"]
	interpretationTerms string (0..1) <"The bespoke provision that might be specified by the parties to the agreement applicable to Interpretations.">
		[synonym ISDA_Create_1_0 value "paragraph_10ki_specify" path "interpretation" set when "interpretation->paragraph_10ki_is" = "specify"]
		[synonym ISDA_Create_1_0 value "paragraph_11g_specify" path "interpretation" set when "interpretation->paragraph_11g_is" = "specify"]
		[synonym ISDA_Create_1_0 value "paragraph_11j_specify" path "interpretation" set when "interpretation->paragraph_11j_is" = "specify"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "15"]
	processAgent ProcessAgent (0..1) <"The Process Agent that might be appointed by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "process_agent"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "16"]
	appropriatedCollateralValuation AppropriatedCollateralValuation (0..1) <"The election for the Valuation of Appropriate Collateral.">
		[synonym ISDA_Create_1_0 value "valuation_of_appropriated_collateral"]
	// [documentReference ISDA CsdInitialMargin 2016 paragraph "13" section "v"]
	jurisdictionRelatedTerms JurisdictionRelatedTerms (0..1) <"The jurisdiction specific terms relevant to the agreement.">
	additionalAmendments string (0..1) <"Any additional amendments that might be specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "specify" path "amendments" maps 2 set when "amendments->is_applicable" = "applicable"] // TODO: remove "maps 2" once migration complete
	additionalBespokeTerms string (0..1) <"Any additional terms that might be specified applicable.">
		[synonym ISDA_Create_1_0 value "specify" path "additional_terms" set when "additional_terms->is_applicable" = "applicable"]
		[synonym ISDA_Create_1_0 value "specify" path "bespoke_provisions" set when "bespoke_provisions->is_applicable" = "applicable"]
	trustSchemeAddendum boolean (1..1) <"The qualification of whether Trust Scheme Addendum is applicable (True) or not applicable (False).">
		[synonym ISDA_Create_1_0 set to True when "trust_scheme_addendum->is_applicable" = "applicable", set to False when "trust_scheme_addendum->is_applicable" = "not_applicable"]

type CreditSupportObligationsInitialMargin: <"A class to specify the Credit Support Obligations applicable to the Initial Margin Credit Support Annex and which are common among the English, Japanese and New York governing laws. This excludes the Other Eligible Support election (which only applies to the Japanese Law and New York Law agreements) and the Transfer Timing election (which only applies to the English Law and the New York Law agreements). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c): Credit Support Obligations. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d): Credit Support Obligations. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c): Credit Support Obligations.">

	marginApproach MarginApproach (0..1) <"The selection of Margin Approach applicable to the agreement.">
		[synonym ISDA_Create_1_0 value "selection_of_margin_approach"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "3(a)"]
	threshold Threshold (1..1) <"The amount of net exposure that a party is willing to bear in relation to the other party before it requires asking for collateral. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(A): Threshold. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(A): Threshold. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(A): Threshold.">
		[synonym ISDA_Create_1_0 value "threshold" mapper "Threshold"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "3(b)(ii)"]
	minimumTransferAmount MinimumTransferAmount (1..1) <"The net amount of exposure reached before collateral has to be posted or returned. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(B): Minimum Transfer Amount. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount.">
		[synonym ISDA_Create_1_0 value "minimum_transfer_amount" mapper "MinimumTransferAmount"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "3(b)(i)"]
	rounding CollateralRounding (0..1) <"The rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(C): Rounding. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding.">
		[synonym ISDA_Create_1_0 value "rounding"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "(c)(v)(C)"]
	bespokeTransferTiming BespokeTransferTiming (0..1) <"The time by which the transfer of collateral must take place when different from the Regular Settlement Day as a result of parties' election.">
		[synonym ISDA_Create_1_0 value "transfer_timing"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "(c)(vi)"]

type CreditSupportObligationsVariationMargin: <"A class to specify the Credit Support Obligations applicable to the Variation Margin Credit Support Annex and which are common among the English, Japanese and New York governing laws. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c): Credit Support Obligations.">

	eligibleCollateral EligibleCollateralVariationMargin (1..1) <"The eligible collateral elections by the parties to the Credit Support Annex for Variation Margin. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(ii): Eligible Collateral (VM).">
	ineligibleCreditSupport IneligibleCreditSupport (1..1) <"The parties to which the provisions of Paragraph 11(g) of the ISDA 2016 Credit Support Annex for Variation Margin will apply to. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(iii): Legally Ineligible Credit Support (VM).">
	majorCurrency string (1..*) <"The set of currencies that are specified as Major Currency for the purpose of applying the FX Haircut Percentage. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(v)(B): FX Haircut Percentage.">
		[metadata scheme]
	// In relation to the above, are the parties expected to always specify the major currencies, or should we have default values specified in the template, deemed to apply if no election by the parties? The current model assumes the former.
	fxHaircut number (1..1) <"The FX haircut percentage that applies to each party (as the pledgor/chargor/obligor) and item of Eligible Collateral unless this item is denominated in a Major Currency or in the Base Currency. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(v)(B): FX Haircut Percentage.">
	// Same question as above: does the template specifies 8% as a default value?
	minimumTransferAmount MinimumTransferAmount (1..1) <"The net amount of exposure reached before collateral has to be posted or returned. ISDA 2016 New York Law Credit Support Annex for Variation Margin, paragraph 13, (c)(vii)(A): Minimum Transfer Amount.">
	rounding CollateralRounding (1..1) <"The rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units. ISDA 2016 New York Law Credit Support Annex for Variation Margin, paragraph 13, (c)(vii)(B): Rounding.">

//TODO - Deprecate: Still used by Variation Margin doc which hasn't been refactored.
type Csa: <"An abstract class to specify the provisions for a ISDA Credit Support Annex that are common among vintages, governing laws and across IM and VM.">

	documentationIdentification DocumentationIdentification (0..1) <"The identification of the legal document(s) that govern the contract through some of the key terms of such document(s): type of document, the document identifier, the publisher, the document vintage and the agreement date.">

//TODO - Deprecate: Still used by Variation Margin doc which hasn't been refactored.
type Csa2016 extends Csa: <"An abstract class to specify the provisions for the 2016 ISDA Credit Support Annex that are common among governing laws and across Initial and Variation Margin.">

	baseCurrency string (1..1) <"The base currency for the Credit Support Annex document as elected by the parties to the agreement. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes. ISDA 2016 CSA for Initial Margin, Paragraph 13 (a) | ISDA 2016 CSA for Variation Margin, Paragraph 13 (a).">
		[metadata scheme]
		[synonym ISDA_Create_1_0 value "currency" path "base_currency"]
	additionalObligations string (0..1) <"The additional obligations that might be specified by the parties to an ISDA CSA. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (b)(ii). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(ii). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(ii). | ISDA 2016 New York Law Credit Support Annex for Variation Margin, paragraph 13, (b)(ii).">
		[synonym ISDA_Create_1_0 value "additional_obligations_specify" path "additional_obligations" set when "additional_obligations->additional_obligations" = "specify"]
	conditionsPrecedent ConditionsPrecedent (1..1) <"The set of elections specified in Paragraph 13 that may overwrite the default Condition Precedent provision as specified in ISDA 2016 Credit Support Annex for Initial Margin, Paragraph 4, (a), and the set of provisions that are deemed Access Condition (Initial Margin) and Specified Condition (Variation Margin). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f): Conditions Precedent. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e): Conditions Precedent. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.">
	substitution Substitution (1..1) <"The conditions under which the Pledgor/Obligor/Chargor can substitute posted collateral. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (f): Substitution. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (g): Substitution. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f): Substitution. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (f): Substitution.">
		[synonym ISDA_Create_1_0 value "consent"]
	disputeResolution DisputeResolution (1..1) <"The election terms under which a party disputes (i) the Calculation Agent’s calculation of a Delivery Amount or a Return Amount, or (ii) the Value of any Transfer of Eligible Credit Support or Posted Credit Support. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (g): Dispute Resolution. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (h): Dispute Resolution. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (g): Dispute Resolution. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (g): Dispute Resolution.">
		[synonym ISDA_Create_1_0 value "resolution_time"]
	additionalRepresentation AdditionalRepresentation (1..1) <"ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (o): Additional Representation(s). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (k): Additional Representation(s).">
		[synonym ISDA_Create_1_0 value "additional_representations"]
	demandsAndNotices ContactElection (1..1) <"The address where the demands, specifications and notices will be communicated to within each of the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (q): Demands and Notices. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (m): Demands and Notices.">
		[synonym ISDA_Create_1_0 value "demands_and_notices"]
	addressesForTransfer ContactElection (1..1) <"The address for transfer as specified by the respective parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (r): Addresses for Transfers. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (n): Addresses for Transfers.">
		[synonym ISDA_Create_1_0 value "addresses_for_transfers"]
	bespokeProvision string (0..1) <"The bespoke provision that might be specified by the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (u)(iii): Other Provisions. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (p): Other Provisions.">
		[synonym ISDA_Create_1_0 value "specify" path "bespoke_provisions" set when "bespoke_provisions->is_applicable" = "applicable"]
	umbrellaAgreement UmbrellaAgreement (0..1) <"The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).">
		[synonym ISDA_Create_1_0 value "umbrella_agreement_and_principal_identification", "principal_identification_schedule" path "umbrella_agreement_and_principal_identification"]

//TODO - Deprecate: Still used by Variation Margin doc which hasn't been refactored.
type CsaVariationMargin2016 extends Csa2016: <"An abstract class to specify the provisions for the 2016 ISDA Credit Support Annex for Variation Margin that are common among governing laws.">

	creditSupportObligations CreditSupportObligationsVariationMargin (1..1) <"The Credit Support Obligations applicable to the Variation Margin Credit Support Annex. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c): Credit Support Obligations.">
	valuationAgent Party (1..1) <"The Valuation Agent as specified by the parties to the agreement. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (d)(i): Valuation Agent.">
		[metadata reference]
	valuationDateLocation CalculationDateLocation (1..1) <"The business location elected by the respective parties to the agreement as the Valuation Date Location. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (d)(ii): Valuation Date Location.">
	valuationTime BusinessCenterTime (1..*) <"ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (d)(iii): Valuation Time.">
	// In relation to the above, need to confirm that several valuation times can be specified, as suggested by the sample document which has been used, although this sounds peculiar if not expressed as one valuation time election per party
	notificationTime int (1..1) <"The extend of time by which a demand for the Transfer of Eligible Credit Support (VM) or Posted Credit Support (VM) needs to be made after the relevant Valuation Time in order for the transfer to take place. This time is expressed in a number of minutes. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (d)(iv): Notification Time.">
	// TODO - Look to express this elapse time as an interval time, to be projected as a a java Interval type https://trello.com/c/hclQUeS0
	holdingAndUsingPostedCollateral HoldingAndUsingPostedCollateral (1..1) <"The elections for the holding and using of posted collateral by the respective parties to the Credit Support Annex for Variation Margin. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h): Holding and Using Posted Collateral (VM).">
	creditSupportOffsets boolean (1..1) <"When True the Credit Support Offsets provisions in Paragraph 11(j) of the ISDA 2016 Credit Support Annex for Variation Margin apply. They don't apply when False. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (j): Credit Support Offsets.">
	otherCsa OtherAgreements (1..1) <"The qualification of whether Other CSA are specified by the parties to the agreement. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (o): Other CSA.">

//TODO - Deprecate: Still used by Variation Margin doc which hasn't been refactored.
type CsaVariationMargin2016NewYorkLaw extends CsaVariationMargin2016: <"A class to specify the provisions that are specific to the New York Law version of the ISDA 2016 Credit Support Annex for Variation Margin.">

	otherEligibleSupport string (0..1) <"The Other Eligible Support election. If not specified, this election is deemed as not applicable. ISDA 2016 New York Law Credit Support Annex for Variation Margin, paragraph 13, (c)(vi): Other Eligible Support (VM).">
	transferTiming string (1..1) <"The time by which the transfer of collateral must take place after the Notification Time on the Regular Settlement Day. ISDA 2016 New York Law Credit Support Annex for Variation Margin, paragraph 13, (c)(viii): Transfer Timing.">
	otherEligibleAndPostedSupport OtherEligibleAndPostedSupport (1..1) <"The Other Eligible Support elections associated with margin agreements. ISDA 2016 New York Law Credit Support Annex for Variation Margin, paragraph 13, (l): Other Eligible Support (VM) and Other Posted Support (VM).">

//TODO - Deprecate: Still used by Equity Master Confirmation doc which hasn't been refactored.
type EquitySwapMasterConfirmation2018 extends EquityMasterConfirmation: <"Specification for the General Terms and Relationship Supplement Elections as provided in the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.">

	typeOfSwapElection ReturnTypeEnum (1..1) <"Part 1 Section 4, 'Dividend Obligations', of the 2018 ISDA CDM Equity Confirmation, Para 4.2 'Dividend Returns': The Type Of Swap Election shall be 'Total Return', unless otherwise specified (as alternative 'Price Return') in the Transaction Supplement.">
	pricingMethodElection PriceReturnTerms (1..1) <"Part 1 Section 5, 'Pricing', of the 2018 ISDA CDM Equity Confirmation, Para 5.1, 'Determining Prices': Each price in relation to a Pricing Date shall be determined pursuant to the specified Pricing Method. The relevant price specified under the column header 'Price' for a corresponding Pricing Date specified under the column header 'Pricing Date' shall be determined using the corresponding method specified under the column header 'Pricing Method'. Pricing Method for the final Equity Valuation Date shall be specified by the Final EVD Pricing Election and Pricing Method for any other Equity Valaution Date shall be 'Securities Close Pricing (Official)'">
	// TODO: the initialPrice attribute should be optional in PriceReturnTerms, only the valuationPriceInterim and valuationPriceFinal methods should be specified at the Swap level
	linearInterpolationElection InterpolationMethodEnum (1..1) <"Part 1 Section 3, 'Floating Obligations', of the 2018 ISDA CDM Equity Confirmation. Para 3.3, 'Linear Interpolation': If the initial Calculation Period is not equal to the Designated Maturity, then the Linear Interpolation Election shall be as specified in the Relationship Supplement, unless otherwise specified in the Transaction Supplement.">
	settlementTerms SettlementTerms (1..1) <"Part 1 Section 8, 'Settlement', of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap. All Settlements are in Cash.">
	equityCalculationPeriod CalculationPeriodDates (1..1) <"The parameters used to generate the 'Equity Valuation Dates' schedule, including the Effective Date and Termination Date for the Swap.">
	equityCashSettlementDates PaymentDates (1..1) <"The parameters used to generate the payment date schedule, relative to the equityCalculationPeriod. Part 1 Section 12, 'Definitions', of the 2018 ISDA CDM Equity Confirmation. Para 73: 'Equity Cash Settlement Date' means each date falling one Settlement Cycle after an Equity Valuation Date; provided that if any such date is not a Settlement Currency Business Day, then such date shall be adjusted per Following Day Adjustment.">

// TODOs: Averaging Election, Dividend Payment Date Election, Break Funding Election
//TODO - Deprecate: Still used by Equity Master Confirmation doc which hasn't been refactored.
type EquityMasterConfirmation extends MasterConfirmationBase: <"Specification for General Terms and Elections of an Equity Master Confirmation that is applicable across multiple Equity confirmations and is referenced by each of these confirmations, an example of which being the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.">

//TODO - Deprecate: Still used by Equity Master Confirmation doc which hasn't been refactored.
type MasterConfirmationBase: <"Legal agreement specification for General Terms and Elections that are applicable across multiple confirmations and are referenced by these confirmations.">

type Custodian: <"A class to specify the custodian and custody account details for each party to the agreement.">

	partyElection CustodianElection (2..2) <"The party specific elections.">

type CustodianElection: <"A class to specify the custodian and custody account details for each party to the agreement.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_custodian_name" exists, set to "partyB" when "partyB_custodian_name" exists]
	custodian LegalEntity (0..1) <"The custody agent. While ISDA Create only specifies the custodian's name, specifying the legal entity as part of the CDM is deemed more appropriate, while this will still provide the ability to accommodate situations where only the entity name is available, as the entityId attribute is optional as part of the LegalEntity class.">
		[synonym ISDA_Create_1_0 value "custodian_name"]
		[synonym ISDA_Create_1_0 value "collateral_manager"]
		[synonym ISDA_Create_1_0 value "custodian_and_segregated_account_details"]
	segregatedCashAccount Account (0..1) <"The identification of the segregated cash account for the purpose of holding cash collateral.">
		[synonym ISDA_Create_1_0 value "custodian_and_segregated_account_details"]
	// TODO - Need for a mapping logic that will parse the ISDA Create suffix to identify cash vs. security with custodian_and_segregated_account_details as a path
	segregatedSecurityAccount Account (0..1) <"The identification of the segregated security account for the purpose of holding security collateral.">
		[synonym ISDA_Create_1_0 value "custodian_and_segregated_account_details"]
	// TODO - Need for a mapping logic that will parse the ISDA Create suffix to identify cash vs. security with custodian_and_segregated_account_details as a path


type CustodianEvent: <"A class to specify the Custodian Event (English Law & New York Law ISDA CSA) and the Collateral Manager Event (Japanese Law ISDA CSA) in terms of applicability and end-date. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(iii): Custodian Event. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(ii): Collateral Manager Event. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): Custodian Event.">

	isApplicable boolean (1..1) <"The qualification as to whether the Custodian Event (English Law & New York Law ISDA CSA) or the Collateral Manager Event (Japanese Law ISDA CSA) is applicable.">
		[synonym ISDA_Create_1_0 set to True when "custodian_event->definition" = "applicable", set to False when "custodian_event->definition" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "euroclear_event->definition" = "applicable", set to False when "euroclear_event->definition" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "clearstream_event->definition" = "applicable", set to False when "clearstream_event->definition" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "collateral_manager_event->definition" = "applicable", set to False when "collateral_manager_event->definition" = "not_applicable"]
	endDate CustodianEventEndDate (0..1) <"The qualification of the Custodian Event (English Law & New York Law ISDA CSA) or Collateral Manager Event (Japanese Law ISDA CSA) End Date.">
		[synonym ISDA_Create_1_0 value "ce_end_date"]
		[synonym ISDA_Create_1_0 value "ee_end_date"]
		[synonym ISDA_Create_1_0 value "cme_end_date"]

type CustodianEventEndDate: <"A class to specify the Custodian Event (English Law & New York Law ISDA CSA) or Collateral Manager Event (Japanese Law ISDA CSA) End Date. Its qualification is function of three elective periods: either (i) a specified number of days after the occurrence of the Custodian Event (the daysAfterCustodianEvent attribute), or (ii) the number of days prior to the date on which the Control Agreement will terminate, with in this latter case (iii) the further qualification of the number of days prior to the Release Date if only one party has effectively provided the Timely Statement to the other party. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(iii): CE End Date. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(ii): CME End Date. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): CE End Date.">

	daysAfterCustodianEvent CustomisableOffset (1..1) <"The parties' election to specify the number of days after the occurrence of the Custodian Event (English Law & New York Law ISDA CSA) or the Collateral Management Event (Japanese Law ISDA CSA) for the purpose of qualifying the CE/CME End Date.">
	// TODO - Need for a mapping logic that will map the elements in ce_end_date which prefix is `after`
		[synonym ISDA_Create_1_0 value "days_after_custodian_event"]
	releaseDate CustomisableOffset (1..1) <"The parties' election to specify the number of days prior to the termination of the Control Agreement (English Law & New York Law ISDA CSA) or the Collateral Management Event (Japanese Law ISDA CSA) for the purpose of qualifying the CE/CME End Date, in the case where advance notice is given.">
	// TODO - Need for a mapping logic that will map the elements in ce_end_date which prefix is `release`
		[synonym ISDA_Create_1_0 value "release_days"]
	dateOfTimelyStatement CustomisableOffset (1..1) <"The parties' election to specify the number of days one party has effectively provided the Timely Statement to the other party.">
		[synonym ISDA_Create_1_0 value "days_after_timely_statement"]

// TODO - Need for a mapping logic that will map the elements in ce_end_date which prefix is `timely` or `date_of_timely`
type CustodianRisk: <"A class to specify the Custodian Risk elections specific to a Credit Support Agreement.">

	partyElection CustodianRiskElection (1..2) <"The party specific elections.">

type CustodianRiskElection: <"A class to specify the Custodian Risk (English Law and New York Law ISDA CSA) and the Collateral Manager Risk (Japanese Law ISDA CSA) election. | ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk. | ISDA 2018 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(i): Collateral Manager Risk. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk.">

	party string (0..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_custodian_risk" = "other", set to "partyA" when  "partyA_custodian_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_custodian_risk" = "other", set to "partyB" when  "partyB_custodian_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_collateral_manager_risk" = "other", set to "partyA" when  "partyA_collateral_manager_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_collateral_manager_risk" = "other", set to "partyB" when  "partyB_collateral_manager_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_clearstream_risk" = "other", set to "partyA" when  "partyA_clearstream_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_clearstream_risk" = "other", set to "partyB" when  "partyB_clearstream_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_euroclear_risk" = "other", set to "partyA" when  "partyA_euroclear_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_euroclear_risk" = "other", set to "partyB" when  "partyB_euroclear_risk" = "not_specified"]
	isSpecified boolean (1..1) <"The qualification as to whether the risk is deemed as Specified.">
		[synonym ISDA_Create_1_0 set to True when "partyA_custodian_risk" = "other", set to False when "partyA_custodian_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "partyB_custodian_risk" = "other", set to False when "partyB_custodian_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "partyA_collateral_manager_risk" = "other", set to False when "partyA_collateral_manager_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "partyB_collateral_manager_risk" = "other", set to False when "partyB_collateral_manager_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "partyA_clearstream_risk" = "other", set to False when "partyA_clearstream_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "partyB_clearstream_risk" = "other", set to False when "partyB_clearstream_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "partyA_euroclear_risk" = "other", set to False when "partyA_euroclear_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "partyB_euroclear_risk" = "other", set to False when "partyB_euroclear_risk" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "paragraph_6b" = "specified", set to False when "paragraph_6b" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "paragraph_6a" = "specified", set to False when "paragraph_6a" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "paragraph_5_2" = "specify", set to False when "paragraph_5_2" = "not_specified"]
	qualification string (0..1) <"The Custodian Risk (English Law and New York Law ISDA CSA) or Collateral Manager Risk (Japanese Law ISDA CSA) qualification. This attribute is optional because the Custodian Risk provision can be deemed as 'Specified', although not be qualified through this attribute.">
		[synonym ISDA_Create_1_0 value "partyA_specify"]
		[synonym ISDA_Create_1_0 value "partyB_specify"]
		[synonym ISDA_Create_1_0 value "paragraph_6b_specify" set when "paragraph_6b" = "specify"]
		[synonym ISDA_Create_1_0 value "paragraph_6a_specify" set when "paragraph_6a" = "specify"]
		[synonym ISDA_Create_1_0 value "paragraph_5_2_specify" set when "paragraph_5_2" = "specify"]


	condition Specified: <"The Custodian Risk (English Law and New York Law ISDA CSA) or Collateral Manager Risk (Japanese Law ISDA CSA) should only be qualified if that risk is deemed 'specified'.">
		if isSpecified = False
		then qualification is absent

type CustodianTerms: <"A class to specify the requirements applicable to the custodian with respect to the holding of posted collateral. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h)(i): Eligibility to Hold Posted Collateral (VM) Custodians (VM).">
	[synonym FpML_5_10 value "CustodianTerms"]

	/*
	 * This class leverages the FpML representation for the ISDA Standard CSA for the purpose of normalizing the election
	 * in the ISDA CSA 2016 for Variation Margin, Paragraph 13, (h)(i)(2).
	 */
	minimumAssets Money (0..1) <"The minimal level of assets requirement with respect to the custody agent.">
		[synonym FpML_5_10 value "minimumAssets"]
	minimumRating CreditNotations (0..1) <"The minimal rating requirement with respect to the custody agent.">
		[synonym FpML_5_10 value "minimumRating"]
	initialDesignation LegalEntity (0..1) <"The 2016 ISDA CSA for Variation Margin provides the ability for the parties to specify the initial custodian.">

type CustodyArrangements: <"A class to specify the Custody Arrangements for the agreement.">
// <"A class to specify the Custody Arrangements for the English Law and New York Law ISDA Credit Support Annex. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n): Custody Arrangements.">
	isCreditSupportDocument boolean (0..1) <"Unless specified as True, the Control Agreement is not a Credit Support Document under the agreement with respect to a party. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 6 (e): The Control Agreement as a Credit Support Document.">
		[synonym ISDA_Create_1_0 set to True when "control_agreement_as_a_credit_support_document->definition" = "creditSupportDocument",
								set to False when "control_agreement_as_a_credit_support_document->definition" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "collateral_management_agreement_as_a_credit_support_document->definition" = "creditSupportDocument",
		    					set to False when "collateral_management_agreement_as_a_credit_support_document->definition" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "euroclear_agreements_as_credit_support_documents->definition" = "creditSupportDocument",
		    					set to False when "euroclear_agreements_as_credit_support_documents->definition" = "not_specified"]
		[synonym ISDA_Create_1_0 set to True when "clearstream_agreements_as_credit_support_documents->definition" = "creditSupportDocument",
		    					set to False when "clearstream_agreements_as_credit_support_documents->definition" = "not_specified"]
	hasControlAgreementLanguage boolean (0..1) <"Control Agreement language is specified when True.">
		[synonym ISDA_Create_1_0 set to True when "relationship_with_the_control_agreement->include_language" = "include", set to False when "relationship_with_the_control_agreement->include_language" = "exclude"]
		[synonym ISDA_Create_1_0 set to True when "relationship_with_the_collateral_management_agreement->include_language" = "include",
								 set to False when "relationship_with_the_collateral_management_agreement->include_language" = "exclude"]
	// TODO - add Condition for hasControlAgreement - include when 2016, exclude when 2018 (captured under CustodyArrangementsElection)
	otherProvisions string (0..1) <"ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(vii): Other Provisions.">
		[synonym ISDA_Create_1_0 value "specify" path "other_provisions" set when "other_provisions->specify_provisions" = "specify"]
	// TODO - add Condition for otherProvisions - include when 2016, exclude when 2018 (captured under CustodyArrangementsElection)
	collateralAccessBreach CollateralAccessBreach (0..1) <"The elections specific to Collateral Access Breach language">
		[synonym ISDA_Create_1_0 value "collateral_access_breach_additional_termination_event"]
		[synonym ISDA_Create_1_0 value "collateral_access_breach"]
	custodianRisk CustodianRisk (0..1) <"The qualification of the Custodian Risk. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk.">
		[synonym ISDA_Create_1_0 value "custodian_risk"]
		[synonym ISDA_Create_1_0 value "collateral_manager_risk"]
		[synonym ISDA_Create_1_0 value "euroclear_risk"]
		[synonym ISDA_Create_1_0 value "clearstream_risk"]
	controlAgreement ControlAgreement (0..1) <"The party-specific election with respect to the control agreement.">
	custodianEvent CustodianEvent (1..1) <"When specified as True, means that the Custodian Events specified in Paragraph 13 General Principles, (m)(iii) will constitute an Additional Termination Event. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(iii): Custodian Event.">
	custodian Custodian (0..1) <"The custodian and segregated account details for each party to the agreement.">
	collateralManagementAgreeement CollateralManagementAgreement (0..1) <"ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(i): Collateral Management Agreement.">
		[synonym ISDA_Create_1_0 value "collateral_management_agreement"]
	distributionAndInterestPayment DistributionAndInterestPayment (0..1) <"The Distributions and Interest Payment as part of the Japanese Law ISDA CSA. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n): Distributions and Interest Payment (IM).">

type CustomisableOffset: <"A class to specify an offset either as a normalized [multiplier, period, dayType] or as a custom provision of type string.">

	offset Offset (0..1)
	customProvision string (0..1)

type DeliveryAmount: <"A class to specify the application of Interest Amount with respect the Delivery Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">

	standardElection DeliveryAmountElectionEnum (0..1) <"The standard election as specified by an enumeration.">
		[synonym ISDA_Create_1_0 value "delivery_amount"]
	customElection string (0..1) <"The custom election that might be specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "specify_delivery_amount"]
	condition: one-of

type DisputeResolution: <"A class to specify the election terms under which a party disputes (i) the Calculation Agent’s calculation of a Delivery Amount or a Return Amount, or (ii) the Value of any Transfer of Eligible Credit Support or Posted Credit Support. Parties can specify such election either through a business center time or through a custom election. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (g): Dispute Resolution. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (h): Dispute Resolution. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (g): Dispute Resolution.">

	resolutionTime BusinessCenterTime (0..1) <"The time by which the dispute needs to be resolved, failure of which would trigger a recalculation alongside a process that is specified as part of the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (g)(i): Resolution Time. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (g)(i): Resolution Time.">
		[synonym ISDA_Create_1_0 value "resolution_time" set when "resolution_time->specified" = "true"]
	otherTerms string (0..1) <"The custom Resolution Time election that might be specified by the parties.">
		[synonym ISDA_Create_1_0 value "specify" path "resolution_time" set when "resolution_time->specified" = "false"]
	// condition: one-of //TODO replace condition when resolutionTime exists otherTerms is absent
	recalculationOfValue RecalculationOfValue (0..1) <"The elections to specify terms for recalculation of the market value of posted collateral.">
		[synonym ISDA_Create_1_0 value "recalculation_of_value"]
		[synonym ISDA_Create_1_0 value "recalculation_of_market_value"]

type DistributionAndInterestPayment: <"A class to specify the Distributions and Interest Payment provisions applicable to the Japanese Law ISDA 2016 CSA for Initial Margin and the New York Law ISDA 2016 CSA for Variation Margin. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n): Distributions and Interest Payment (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i): Distributions and Interest Payment (VM).">

	interestRate EligibleCurrencyInterestRate (1..*) <"The interest rate associated with initial or variation margin collateral, depending upon the type of credit agreement that this election is associated with. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(i): Interest Rate (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(i): Interest Rate (VM).">
		[synonym ISDA_Create_1_0 value "eligible_currencies" path "interest_rate"]
	interestPaymentTransfer boolean (1..1) <"The Interest Payment Transfer is applicable when True. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Transfer of Interest Payment (IM) or application of Interest Amount (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(ii): Transfer of Interest Payment (VM) or application of Interest Amount (VM).">
		[synonym ISDA_Create_1_0 set to True when "interest_transfer->interest_transfer" = "applicable", set to False when "interest_transfer->interest_transfer" = "not_applicable"]
	interestPaymentNetting boolean (1..1) <"The Interest Payment Netting is applicable when True. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Transfer of Interest Payment (IM) or application of Interest Amount (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(ii): Transfer of Interest Payment (VM) or application of Interest Amount (VM).">
		[synonym ISDA_Create_1_0 set to True when "interest_payment_netting->interest_payment_netting" = "applicable", set to False when "interest_payment_netting->interest_payment_netting" = "not_applicable"]
	interestAmount InterestAmount (1..1) <"The application of Interest Amount with respect to the Delivery Amount and the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">
		[synonym ISDA_Create_1_0 value "return_amount_delivery_amount"]
	interestAdjustment InterestAdjustment (1..1) <"To election to specify whether the Interest Adjustment is applicable and what its periodicity is. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(ii): Transfer of Interest Payment (VM) or application of Interest Amount (VM).">
		[synonym ISDA_Create_1_0 value "interest_adjustment"]
	negativeInterest boolean (1..1) <"Negative Interest is applicable when True, and not applicable when False. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): Other Interest Elections. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(iii): Other Interest Elections.">
		[synonym ISDA_Create_1_0 set to True when "negative_interest->negative_interest" = "applicable", set to False when "negative_interes->negative_interest" = "not_applicable"]
	dailyInterestCompounding boolean (1..1) <"Daily interest compounding is applicable when True, and not applicable when False. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iii): Other Interest Elections. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(iii): Other Interest Elections.">
		[synonym ISDA_Create_1_0 set to True when "daily_interest_compounding->daily_interest_compounding" = "applicable", set to False when "daily_interest_compounding->daily_interest_compounding" = "not_applicable"]
	alternativeProvision string (0..1 ) <"When the alternative provision clause is specified, it means that the ISDA CSA Japanese Law provisions specified in Paragraph 6(c)(ii) don't apply and are overwritten by this election. When it is not specified, it means that the ISDA CSA Japanese Law provisions specified in Paragraph 6(c)(ii) apply. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(iv): Alternative to Interest Amount (IM) and Interest Payment (IM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (i)(iv): Alternative to Interest Amount (VM) and Interest Payment (VM).">
		[synonym ISDA_Create_1_0 value "specify" path "alternative_to_interest_amounts_and_interest_payment" set when "alternative_to_interest_amounts_and_interest_payment->specify_alternative" = "true"]

// Note: Threshold, MinimumTransferAmount and MinimumTransferAmountAmendment class map to this one
type ElectiveAmountElection: <"A class to specify the party elective amounts which can be used for the purpose of specifying elections such as the ISDA CSA Threshold and Minimum Transfer Amount.">

	party string (1..1) <"The elective party.">
	zeroAmount boolean (1..1) <"A boolean election to express that the elective amount is zero (True) or another value (False).">
	amount Money (0..1) <"The elective amount when expressed as a currency amount. The associated PartyElectiveAmount_amount data rule enforces that the currency amount is actually greater than 0.">
	customElection string (0..1) <"The elective amount when expressed as a custom election by the party.">

	condition NonZeroAmount: <"When the elective amount is not zero either a currency amount or a custom election must exist.">
		if zeroAmount = False then (amount or customElection) exists

type EligibilityToHoldCollateral: <"A class to specify the conditions under which a party and its custodian(s) are entitled to hold collateral. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h)(i): Eligibility to Hold Posted Collateral (VM) Custodians (VM).">
	[synonym FpML_5_10 value "EligibilityToHoldCollateral"]
	/*
	 * This class leverages work in the context of the FpML representation for the ISDA Standard CSA for the purpose of normalizing this election
	 * Those provisions go beyond what is specified as part of the 2016 CSA, which election has not yet been normalized
	 */
	partyTerms HoldingPostedCollateralEnum (1..*) <"The condition(s) required by a party from the other party to hold its posted collateral.">
		[synonym FpML_5_10 value "holdingPostedCollateral"]
	custodianTerms CustodianTerms (0..1) <"The restrictions that might be required by a party from the other party's custodian agent to hold its posted collateral.">
		[synonym FpML_5_10 value "custodianTerms"]
	eligibleCountry string (0..*) <"The restrictions that might be required by a party from the other party in terms of country(ies) where collateral can be held.">
		[metadata scheme]
		[synonym FpML_5_10 value "eligibleCountry"]

type EligibleCollateralVariationMarginElection: <"A class to specify the parties' elections with respect to the eligible collateral for each of the respective parties when acting as a pledgor/chargor/obligor. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(ii): Eligible Collateral (VM).">

	party Party (1..1) <"The elective party.">
		[metadata reference]
	eligibleCollateral EligibleCollateral (1..*) <"The eligible collateral for the specified party (acting as the Pledgor in the New York Law agreement, as the Chargor in the English Law deed and as the Obligor in the Japanese Law agreement). ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(ii): Eligible Collateral (VM).">

type EligibleCollateralVariationMargin: <"A class to specify the eligible collateral elections by the respective parties to the Credit Support Annex for Variation Margin. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(ii): Eligible Collateral (VM).">

	// TODO: change cardinality to (2..2) when Ingestion process is able to support normalising external models (https://trello.com/c/TnJWvKes)
	partyElection EligibleCollateralVariationMarginElection (1..1) <"The parties' eligible collateral elections.">

type EligibleCurrencyInterestRate: <"A class to specify the interest rate associated with initial margin collateral. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n): Distributions and Interest Payment (IM).">

	currency string (1..1) <"The eligible currency.">
		[metadata scheme]
		[synonym ISDA_Create_1_0 value "eligible_currency"]
	interestRate number (1..1) <"The interest rate associated with the eligible currency.">
		[synonym ISDA_Create_1_0 value "interest_rate"]
	actual365Currency string (1..1) // TODO - Need to clarify with Linklater what this attribute is
		[synonym ISDA_Create_1_0 value "a365_currency"]

type EnforcementEvent: <"A class to specify Enforcement Events specific to Security Agreements">

	earlyTerminationDate boolean (1..1) <"The early termination election">
		[synonym ISDA_Create_1_0 set to True when "paid_in_full_language" = "include", set to False when "paid_in_full_language" = "exclude"]
	failureToPay boolean (0..1) <"The failure to pay election">
		[synonym ISDA_Create_1_0 set to True when "failure_to_pay_early_termination_amount" = "applicable", set to False when "failure_to_pay_early_termination_amount" = "not_applicable"]

type ExecutionLanguage: <"A class to specify execution language terms of a Security Agreement.">
	standardLanguage boolean (1..1) <"A boolean attribute to determine if standard language is applicable or not">
		[synonym ISDA_Create_1_0 set to True when "execution_language" = "standard_language", set to False when "execution_language" = "other_execution_language"]
	numberOfOriginals string (0..1) <"The number of original documents">
		[synonym ISDA_Create_1_0 value "number_of_originals"]
	otherLanguage string (0..1) <"Bespoke execution language to be included when specified.">
		[synonym ISDA_Create_1_0 value "specify_execution_language"]

	condition numberOfOriginals: <"A data rule to enforce that the number of original documents should only be specified when standard execution language is used.">
		if standardLanguage = False
		then numberOfOriginals is absent

	condition otherLanguage: <"A data rule to enforce that bespoke execution language must be included if non-standard execution language is specified.">
		if standardLanguage = False
		then otherLanguage exists

type ExecutionLocation: <"A class to specify execution location terms of a Security Agreement">
	executionLocation ExecutionLocationEnum (1..1) <"The execution location of the agreement">
		[synonym ISDA_Create_1_0 value "location_of_execution"]
	otherLanguage string (0..1) <"Bespoke execution location language to be included when specified.">
		[synonym ISDA_Create_1_0 value "specify_location_of_execution"]
	dutyPayer string (0..1) <"The payer of documentary duty">
		[synonym ISDA_Create_1_0 set to "PartyA" when "documentary_duty_payer" = "party_A",
									set to "PartyB" when "documentary_duty_payer" = "party_B",
									set to "Specify" when "documentary_duty_payer" = "other"]
	dutyPayerLanguage string (0..1) <"Bespoke terms specific to the payment of documentary duty">
		[synonym ISDA_Create_1_0 value "specify_documentary_duty_payer"] // path "documentary_duty_payer"]
	dutyPaymentDate date (0..1) <"The date that documentary duty will be paid">
		[synonym ISDA_Create_1_0 value "select_documentary_duty_date"] // set when "documentary_duty_date" = "select"
	dutyPaymentLanguage string (0..1) <"Bespoke terms specific to the date that documentary duty will be paid">
		[synonym ISDA_Create_1_0 value "specify_documentary_duty_date_datepicker" set when "documentary_duty_date" = "other"]

// TODO Data Rule required to enforce that Duty Payer should be absent if LocationEnum is ExecutedOutsideBelgium or Other (OR included if Enum is ExecutedInBelgium)
	// condition dutyPayer: <"A data rule to enforce that Duty Payer language should be absent when the document is executed outside of Belgium.">
	// 	if executionLocation = ExecutionLocationEnum->ExecutedOutsideBelgium
	// 	then dutyPayer and dutyPayerLanguage and dutyPaymentDate and dutyPaymentLanguage is absent

	condition dutyPayerLanguage: <"A data rule to enforce that Duty Payer Language should only be specified when required">
		if dutyPayer = "Specify"
		then dutyPayerLanguage exists

	condition dutyPaymentLanguage: <"A data rule to enforce that Duty Payment Language should be absent when a Duty Payment date is provided">
		if dutyPaymentDate exists then dutyPaymentLanguage is absent

	condition otherLanguage: <"A data rule to enforce that bespoke execution language must be included if non-standard execution language is specified.">
		if executionLocation = ExecutionLocationEnum->OtherLocation
		then otherLanguage exists

type ExecutionTerms: <"A class to specify execution location and language of execution to determine duty to be paid.">
	executionLanguage ExecutionLanguage (1..1) <"The bespoke execution language election.">
	executionLocation ExecutionLocation (1..1) <"The bespoke execution location election.">

type FrenchLawAddendum: <"A class to specify party specific elections when a Collateral Transfer Agreement is governed by French Law.">

	isApplicable boolean (1..1) <"The qualification of whether the French Law Addendum is deemed applicable by the parties (True) or not (False).">
<<<<<<< HEAD
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]		
=======
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	partyElection FrenchLawAddendumElection (2..2) <"The parties French Law Addendum Elections.">

	condition Applicable: <"A data rule to enforce that the French Law Addendum party elections must be specified when applicable.">
		if isApplicable = True
		then partyElection exists

type FrenchLawAddendumElection: <"A class to specify party specific French Law Addendum language">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_french_law_addendum" = "specify", set to "partyA" when "partyA_french_law_addendum" = "not_applicable",
								 set to "partyB" when "partyB_french_law_addendum" = "specify", set to "partyB" when "partyB_french_law_addendum" = "not_applicable"]
	isApplicable boolean (1..1) <"The qualification of whether the party elects specific language">
		[synonym ISDA_Create_1_0 set to True when "partyA_french_law_addendum" = "specify", set to False when "partyA_french_law_addendum" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_french_law_addendum" = "specify", set to False when "partyB_french_law_addendum" = "not_applicable"]
	addendumLanguage string (0..1) <"The party specific language to be included in the agreement.">
		[synonym ISDA_Create_1_0 value "partyA_specify"]
		[synonym ISDA_Create_1_0 value "partyB_specify"]

	condition AddendumLanguage: <"A data rule to enforce that the French Law Addendum party language must be specified when applicable.">
		if isApplicable = True then addendumLanguage exists
		else if isApplicable = False then addendumLanguage is absent

type FxHaircutCurrency: <"A class to specify the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.">

	isTerminationCurrency boolean (1..1) <"The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation is the Termination Currency when the Boolean value is set to True.">
		[synonym ISDA_Create_1_0 set to True when "is_termination_currency" = "terminationCurrency", set to False when "is_termination_currency" = "fxCurrency"]
	fxDesignatedCurrency string (0..1) <"When specified, the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.">
		[metadata scheme]
		[synonym ISDA_Create_1_0 value "fx_designated_currency"]

	condition TerminationCurrency: <"The FX Designated Currency shouldn't be specified when the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation is specified as the Termination Currency.">
		if isTerminationCurrency = True
		then fxDesignatedCurrency is absent

	condition FxDesignatedCurrency: <"The FX Designated Currency should be specified when the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation is specified as not being the Termination Currency.">
		if isTerminationCurrency = False
		then fxDesignatedCurrency exists

type GeneralSimmElections: <"A class to specify the ISDA SIMM as the Method for all Covered Transactions with respect to all Regimes. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ee).">

	simmVersion SimmVersion (0..1) <"The qualification of the ISDA SIMM version that is specified for all Covered Transactions as specified by ISDA 2018 CSA for Initial Margin, Paragraph 13, General Principles, (ee)(1).">
		// ISDA Create for the 2016 IM NY Law only has the election for the SIMM calculation currency
		[synonym ISDA_Create_1_0 value "version_of_ISDA_SIMM"]
	simmCalculationCurrency SimmCalculationCurrency (1..1) <"The SIMM Calculation Currency, as specified for each of the parties to the CSA Initial Margin. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ee)(3).">
		[synonym ISDA_Create_1_0 value "simm_calculation_currency"]

type HoldingAndUsingPostedCollateral: <"A class to specify the elections for the holding and using of posted collateral by the respective parties to the Credit Support Annex for Variation Margin. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h): Holding and Using Posted Collateral (VM).">

	// TODO: change cardinality to (2..2) when Ingestion process is able to support normalising external models (https://trello.com/c/TnJWvKes)
	partyElection HoldingAndUsingPostedCollateralElection (1..1) <"The parties' elections for the holding and using of posted collateral.">

type HoldingAndUsingPostedCollateralElection: <"A class to specify the parties' elections related to the holding and using of posted collateral. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h): Holding and Using Posted Collateral (VM).">
	[synonym FpML_5_10 value "HoldingAndUsingPostedCollateral"]

	party Party (1..1) <"The elective party.">
		[metadata reference]
		[synonym FpML_5_10 value "partyReference"]
	eligibilityToHoldCollateral EligibilityToHoldCollateral (1..1) <"The specification of the conditions under which a party and its custodian(s) are entitled to hold posted collateral.">
		[synonym FpML_5_10 value "eligibilityToHoldCollateral"]
	useOfPostedCollateral boolean (1..1) <"Specifies whether the party to the agreement has the right to rehypothecate the collateral held (True), i.e. whether the condition specified in Paragraph 6, (c) of the ISDA 2016 Credit Support Annex for Variation Margin apply. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h)(ii): Use of Posted Collateral (VM).">
		[synonym FpML_5_10 value "useOfPostedCollateral"]

type IneligibleCreditSupport: <"A class to specify the parties to which the provisions of Paragraph 11(g) of the ISDA 2016 Credit Support Annex for Variation Margin will apply to. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(iii): Legally Ineligible Credit Support (VM).">

	specifiedParty Party (0..2) <"The parties to which the provisions of Paragraph 11(g) of the ISDA 2016 Credit Support Annex for Variation Margin will apply to, as the Secured Party. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(iii): Legally Ineligible Credit Support (VM).">
		[metadata reference]

type InterestAdjustment: <"A class to specify whether the Interest Adjustment is applicable and what its periodicity is. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">

	isApplicable boolean (1..1) <"The Interest Adjustment is applicable when True and not applicable when False">
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
	periodicity InterestAdjustmentPeriodicity (1..1) <"The qualification of the Interest Adjustment periodicity.">

type InterestAdjustmentPeriodicity: <"A class to specify the Interest Adjustment periodicity either through a standardized election or a custom one. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">

	standardElection InterestAdjustmentPeriodicityEnum (0..1) <"The Interest Adjustment periodicity when specified through a standardized election.">
		[synonym ISDA_Create_1_0 value "timing"]
	customElection string (0..1) <"The Interest Adjustment periodicity when specified through a custom election.">
		[synonym ISDA_Create_1_0 value "specify" set when "timing" = "other"]
	condition: one-of

type InterestAmount: <"A class to specify the application of Interest Amount with respect to the Delivery Amount and the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">

	returnAmount ReturnAmount (1..1) <"The application of Interest Amount with respect the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">
	deliveryAmount DeliveryAmount (1..1) <"The application of Interest Amount with respect the Delivery Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">

type JapaneseSecuritiesProvisions: <"A class to specify Japanese Securities Provision elections.">

	isApplicable boolean (1..1) <"Japanese Securities Provisions are applicable when True and Not Applicable when False">
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
	relevantProvisionsElection boolean (0..1) <"Recommended Japanese Securities Provisions are applicable when True, additional Provisions are specified when False">
		[synonym ISDA_Create_1_0 set to True when "relevant_provisions" = "recommended_japanese", set to False when "relevant_provisions" = "specified"]
	relevantProvisionsTerms string (0..1) <"Specific terms applicable to Recommended Japanese Securities Provisions">
		[synonym ISDA_Create_1_0 value "relevant_specify"]
	amendmentsToJapaneseProvisions boolean (0..1) <"Additional Amendments to Japanese Securities Provisions are specified when True, and not specified when False">
		[synonym ISDA_Create_1_0 set to True when "amendments_to_japanese_provisions" = "amendments_specify", set to False when "amendments_to_japanese_provisions" = "amendments_not_specified"]
	amendmentsToJapaneseProvisionsTerms string (0..1) <"Specific terms applicable to Additional Amendments to Japanese Securities Provisions">
		[synonym ISDA_Create_1_0 value "amendments_specify" maps 2] // TODO: remove "maps 2" once migration complete

	condition relevantProvisionsElection: <"A data rule to enforce that the specific terms applicable to Recommended Japanese Securities Provisions should be specified when required">
		if relevantProvisionsElection = True
		then relevantProvisionsTerms is absent

	condition amendmentsToJapaneseProvisions: <"A data rule to enforce that the specific terms applicable to Additional Amendments to Japanese Securities Provisions should be specified when required">
		if amendmentsToJapaneseProvisions = False
		then amendmentsToJapaneseProvisionsTerms is absent

type JurisdictionRelatedTerms: <"A class to specify terms jurisdiction related terms.">
	japaneseSecuritiesProvisions JapaneseSecuritiesProvisions (0..1) <"The Japanese Securities Provisions election.">
	// [documentReference ISDAEuroclear CtaInitialMargin 2019 paragraph "13" section "19 (c)"]
		[synonym ISDA_Create_1_0 value "japanese_securities_provisions"]
		[synonym ISDA_Create_1_0 value "japanese_collateral_provisions"]
	exclusiveJurisdiction boolean (0..1) <"Classification of optional exclusive jurisdiction terms">
		[synonym ISDA_Create_1_0 set to True when "jurisdiction->exclusive_jurisdiction" = "applicable", set to False when "jurisdiction->exclusive_jurisdiction" = "not_applicable"]
	juryWaiver boolean (0..1) <"The Jury Waiver conditions specific to the agreement.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "19 (b)"]
		[synonym ISDA_Create_1_0 set to True when "jury_waiver->is_applicable" = "applicable", set to False when "jury_waiver->is_applicable" = "not_applicable"]
	frenchLawAddendum FrenchLawAddendum (0..1) <"The French Law Addendum Provisions specific to the agreement.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "19 (d)"]
		[synonym ISDA_Create_1_0 value "french_law_addendum"]

type LegalAgreement extends LegalAgreementBase: <"A class to specify the elections and variables that characterize a legal agreement.">
	[metadata key]
 	[rootType]

 	// agreementQualifier agreementType (0..1) <"The CDM agreement qualifier, which corresponds to the outcome of the isContract qualification logic. This value is derived by the CDM from the contract features.">
	agreementTerms AgreementTerms (0..1) <"The set of elections specific to the contract">

	condition agreementVerification: <"A validation rule to ensure that the agreement elections are associated with the correct legal agreement type as specified.">
		if agreementTerms -> agreement -> securityAgreementElections exists
		then agreementType -> name = LegalAgreementNameEnum->SecurityAgreement

		else if agreementTerms -> agreement -> creditSupportAgreementElections exists
		then agreementType -> name = LegalAgreementNameEnum->CreditSupportDeed or agreementType -> name = LegalAgreementNameEnum->CreditSupportAnnex

		else if agreementTerms -> agreement -> collateralTransferAgreementElections exists
		then agreementType -> name = LegalAgreementNameEnum->CollateralTransferAgreement

type LegalAgreementBase: <"A class describing the legal agreement baseline information, other than the specialized elections: type of legal agreement, agreement date and effective date, parties to the agreement, ... The purpose of this abstract class is to provide the ability to associate a 'one of' feature to the LegalAgreement class as a way to enforce a systematic choice between its attributes.">

	agreementDate date (1..1) <"The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.">
		[synonym FpML_5_10 value "agreementDate" path "legalDocumentHeader"]
		[synonym ISDA_Create_1_0 value "executionDate" path "answers->partyA->execution_date"]
		[synonym ISDA_Create_1_0 value "collateral_transfer_agreement_date"]
		[synonym ISDA_Create_1_0 value "master_agreement_date"]
		[synonym ISDA_Create_1_0 value "partyA_date_of_security_agreement"]
		[synonym ISDA_Create_1_0 value "partyB_date_of_security_agreement"]
	effectiveDate date (0..1) <"The date on which the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.">
		[synonym FpML_5_10 value "effectiveDate" path "legalDocumentHeader"]
	identifier Identifier (0..*) <"The legal agreement identifier. Several identifiers can be specified.">
		[synonym FpML_5_10 value "partyDocumentIdentifier" path "legalDocumentHeader"]
	lineage Lineage (0..1) <"The lineage into prior versions of this legal agreement or into other legal agreements that might be referenced by it.">
	agreementType LegalAgreementType (1..1) <"The type of legal agreement, identified via a set of distinct attributes: name, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.">
		[synonym FpML_5_10 value "documentType"]
	contractualParty Party (2..2)  <"The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.">
		[metadata reference]
		[synonym FpML_5_10 value "party"]
	otherParty PartyRole (0..*) <"The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.">
	partyInformation Party (2..*) <"The information about the parties involved with the legal agreements, which consists of both the contractual parties and the parties that might be involved in relation to some other roles (e.g. custody agent).">
		[synonym ISDA_Create_1_0 value "answers" mapper "PartyInformation"]

type LegalAgreementType: <"A class to specify the type of legal agreement, which is extended by each legal agreement instance, such as the ISDA 2016 CSA for Initial Margin.">
	[synonym FpML_5_10 value "LegalDocumentType"]

	name LegalAgreementNameEnum (1..1) <"The legal agreement name, e.g. Credit Support Annex for Variation Margin.">
		[synonym FpML_5_10 value "name"]
		[synonym AcadiaSoft_AM_1_0 value "documentName"]
		[synonym ISDA_Create_1_0 value "documentType" path "document"]
	publisher LegalAgreementPublisherEnum (1..1) <"The legal agreement publisher, e.g. ISDA.">
		[synonym FpML_5_10, AcadiaSoft_AM_1_0 value "publisher"]
		[synonym ISDA_Create_1_0 value "publisher" path "document"]
	governingLaw GoverningLawEnum (0..1) <"The law governing the legal agreement, e.g. English Law, New York Law or Japanese Law.">
		[synonym FpML_5_10 value "style"]
		[synonym AcadiaSoft_AM_1_0 value "governingLaw"]
		[synonym ISDA_Create_1_0 value "governingLaw" path "document"]
	vintage string (0..1) <"In the case where successive definitions of the legal agreement have been developed, the vintage identification. This is typically (but not necessarily) done by referencing the year, e.g. 2013 in the case of the ISDA 2013 Standard Credit Support Annex.">
		[synonym FpML_5_10, FpML_5_10 value "version"]
		[synonym AcadiaSoft_AM_1_0 value "csaVersion"]
		[synonym ISDA_Create_1_0 value "year" path "document"]
		[synonym ISDA_Create_1_0 value "isda_master_agreement_form"]

type MarginApproach: <"A class for selection of Margin Approach.">

	marginApproach MarginApproachEnum (1..1)
		[synonym ISDA_Create_1_0 value "approach_selection"]

type MinimumTransferAmount: <"A class to specify amount of exposure reached before collateral has to be posted or returned. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(B): Minimum Transfer Amount. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount.">

	partyElection ElectiveAmountElection (2..2) <"The parties' minimum transfer amount elections.">

type MinimumTransferAmountAmendment: <" A class to specify whether Amendment to Minimum Transfer Amount language is applicable or not">

	isApplicable boolean (1..1) <"The definition of Minimum Transfer Amount in any Other Regulatory CSA will be amended when applicable.">
		[synonym ISDA_Create_1_0 set to True when "amendment_to_minimum_transfer_amount_is" = "applicable", set to False when "amendment_to_minimum_transfer_amount_is" = "not_applicable"]
	effectiveDate AmendmentEffectiveDate (0..1) <"The effective date of the Amendment to Termination Currency.">
	partyElections ElectiveAmountElection (0..2) <"The party elective amounts.">

	condition AmendmentNotApplicable: <"A data rule to enforce that the Effective Date and Party Elections should be absent when the Minimum Transfer Amount Amendment is stated as not specified for the 											agreement.">
		if isApplicable = False
		then effectiveDate is absent and partyElections is absent

	condition AmendmentApplicable: <"A data rule to enforce that the Effective Date and Party Elections should be absent when the Minimum Transfer Amount Amendment is stated as not specified for the 											agreement.">
		if isApplicable = True
		then effectiveDate exists and partyElections exists

type MultipleCreditNotations: <"A class to specify multiple credit notations alongside a conditional 'any' or 'all' qualifier.">

	condition QuantifierEnum (1..1) <"An enumerated element, to qualify whether All or Any credit notation applies.">
		[synonym FpML_5_10 value "condition"]
	creditNotation CreditNotation (2..*) <"At least two credit notations much be specified.">
		[metadata scheme]
		[synonym FpML_5_10 value "debtType" meta "creditNotation"]
	mismatchResolution CreditNotationMismatchResolutionEnum (0..1)
	referenceAgency CreditRatingAgencyEnum (0..1)

	condition ReferenceAgency: <"If the mismatch resolution is ReferenceAgency, ensure that the reference agency is specified.">
		if MultipleCreditNotations -> mismatchResolution = CreditNotationMismatchResolutionEnum -> ReferenceAgency
		then MultipleCreditNotations -> referenceAgency exists

type MultipleDebtTypes: <"A class to specify multiple credit debt types alongside a conditional 'any' or 'all' qualifier.">

	condition QuantifierEnum (1..1) <"An enumerated attribute, to qualify whether All or Any debt type applies.">
		[synonym FpML_5_10 value "condition"]
	debtType string (2..*) <"The type of debt, e.g. long term debt, deposit, ... FpML doesn't specific a scheme value, hence no enumeration is specified as part of the CDM. At least two debt types much be specified.">
		[metadata scheme]
		[synonym FpML_5_10 value "debtType" meta "debtTypeScheme"]

type NotificationTime: <"A class to specify the time by which a demand for the Transfer of Eligible Credit Support (IM) or Posted Credit Support (IM) needs to be made in order for the transfer to take place in accordance with the Transfer Timing provisions. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(iii): Notification Time. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time.">

	partyElections NotificationTimeElection (2..2) <"The parties' Notification Time election.">
	disputeNotificationReference boolean (0..1) <"The determination of whether reference is made to dispute resolution notification timing in the agreement.">
		[synonym ISDA_Create_1_0 set to True when "include_reference_to_41a_is_applicable" = "applicable", set to False when "include_reference_to_41a_is_applicable" = "not_applicable"]
	transferTimingProviso boolean (0..1) <"The determination of whether transfer timing language is applicable or not.">
		[synonym ISDA_Create_1_0 set to True when "inclusion_of_proviso_for_transfer_timing_is_applicable" = "applicable",
									set to False when "inclusion_of_proviso_for_transfer_timing_is_applicable" = "not_applicable"]

type NotificationTimeElection: <"A class to specify the notification time election by the respective parties to the agreement. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(iii): Notification Time. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_notification_time" = "false", set to "partyA" when "partyA_notification_time" = "true"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_notification_time" = "false", set to "partyB" when "partyB_notification_time" = "true"]
	notificationTime BusinessCenterTime (0..1) <"The Notification Time as a time that is qualified as a standard business center.">
	customNotification string (0..1) <"The Notification Time as a custom election.">
		[synonym ISDA_Create_1_0 value "partyA_specify" set when "partyA_notification_time" = "false"]
		[synonym ISDA_Create_1_0 value "partyB_specify" set when "partyB_notification_time" = "false"]

	condition Choice: <"The Notification Time is specified either as a time that is qualified by a standard business center or as a custom election.">
		required choice notificationTime, customNotification

type OneWayProvisions: <"A class to specify whether One Way Provisions apply in relation to the ISDA CSA for Initial Margin and, if yes, to specify the Posting Party. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles (aa): One Way Provisions.">

	isApplicable boolean (1..1) <"The determination of whether the One Way Provisions are applicable (true) or not applicable (false).">
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
	postingParty string (0..1) <"The Posting Party for the purposes of One Way Provisions. It is specified in the case where the One Way Provision is deemed applicable.">
		[synonym ISDA_Create_1_0 value "posting_party"]

	condition PostingPartyExists: <"A data rule to enforce that the Posting Party must be specified in the case where the One Way Provision is deemed applicable.">
		if isApplicable = True
		then postingParty exists

	condition PostingPartyAbsent: <"A data rule to enforce that the Posting Party must not be specified in the case where the One Way Provision is not deemed applicable.">
		if isApplicable = False
		then postingParty is absent

type OtherAgreements: <"A class to specify a related legal agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (s): Other CSA and Japanese Law CSA (VM). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (o): Other CSA.">

	isSpecified boolean (1..1) <"The qualification of whether some other related agreement is specified (True) or not (False).">
		[synonym ISDA_Create_1_0 set to True when "specify_japanese_law_csa_vm" = "true", set to False when "specify_japanese_law_csa_vm" = "false"]
		[synonym ISDA_Create_1_0 set to True when "specify_other_csa" = "true", set to False when "specify_other_csa" = "false"]
	legalDocument string (0..1) <"The specification of this other agreement, when the qualification is True.">
		[synonym ISDA_Create_1_0 value "specify"]

	condition LegalDocumentNotSpecified: <"A data rule to enforce that the related legal agreement should not be referenced if it is deemed as not specified as part of the boolean attribute.">
		if isSpecified = False
		then legalDocument is absent

	condition LegalDocumentSpecified: <"A data rule to enforce that the related legal agreement should be referenced if it is deemed as specified as part of the boolean attribute.">
		if isSpecified = True
		then legalDocument exists
// TODO - Need to associate a more meaningful definition to the below class and attribute.  I couldn't find anything as part of the CSA terms.
type OtherEligibleAndPostedSupport: <"A class to specify the Other Eligible Support elections associated Initial and Variation margin agreements.">

	otherEligibleSupport string (0..1) <"The Other Eligible Support election. If not specified, this election is deemed as not applicable.">
		[synonym ISDA_Create_1_0 value "eligible_support_specify" path "other_eligible_support" set when "other_eligible_support->other_eligible_support" = "specify"]
		[synonym ISDA_Create_1_0 value "other_eligible_support" path "eligible_support"]
	applicableValue boolean (1..1) <"The definition of “Value” with respect to Other Eligible Support (IM) and Other Posted Support (IM).">
		[synonym ISDA_Create_1_0 set to True when "support_value->is_applicable" = "applicable",	set to False when "support_value->is_applicable" = "not_applicable"]
	applicableTransfer boolean (0..1) <"The definition of “Transfer” with respect to Other Eligible Support (IM) and Other Posted Support (IM).">
		[synonym ISDA_Create_1_0 set to True when "support_transfer->is_applicable" = "applicable", set to False when "support_transfer->is_applicable" = "not_applicable"]

type PartyAgreementIdentifier: <"A class defining a legal agreement identifier issued by the indicated party.">
	[metadata key]
	// TODO Never referenced in CDM
	[synonym FpML_5_10 value "PartyDocumentIdentifier" meta "id"]

	partyReference string (1..1) <"Reference to the party that issued the document identifier.">
		[synonym FpML_5_10 value "partyReference"]
	documentIdentifier Identifier (1..*) <"While FpML specifies the document identifier with a value and an associated scheme, the CDM makes use of the Identifier, which has an explicit issuer. The issuer of this identifier is not necessarily the same as the party reference.">
		[metadata scheme]
		[synonym FpML_5_10 value "documentId" meta "legalDocumentIdScheme"]

type PostingObligations: <"A class to specify the security provider(s) collateral posting obligations as specified under the terms of the New York Law ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ii).">

	securityProvider string (1..1)
		[synonym ISDA_Create_1_0 value "pledgor"]
		[synonym ISDA_Create_1_0 value "chargor"]
		[synonym ISDA_Create_1_0 value "obligor"]
		[synonym ISDA_Create_1_0 value "security_provider"]
	partyElection PostingObligationsElection (1..2) <"The security provider party(ies) to which the posting obligations apply to, which can be either one of the parties to the legal agreement, or both of those.">
<<<<<<< HEAD
	
=======

>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
type PostingObligationsElection: <"A class to specify the collateral posting obligations as specified under the terms of the ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ii).">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "PartyA" when "partyA_type" = "control_agreement", set to "PartyA" when "partyA_type" = "collateral_management_agreement", set to "PartyA" when "partyA_type" = "specify"]
		[synonym ISDA_Create_1_0 set to "PartyB" when "partyB_type" = "control_agreement", set to "PartyB" when "partyB_type" = "collateral_management_agreement", set to "PartyB" when "partyB_type" = "specify"]
	asPermitted boolean (1..1) <"If set to True, the Control Agreement is a Credit Support Document with respect to the party(ies). ISDA 2016 Credit Support Annex for Initial Margin, paragraph 6, (e).">
		[synonym ISDA_Create_1_0 set to True when "partyA_type" = "control_agreement", set to True when "partyA_type" = "collateral_management_agreement", set to False when "partyA_type" = "specify"]
		[synonym ISDA_Create_1_0 set to True when "partyB_type" = "control_agreement", set to True when "partyB_type" = "collateral_management_agreement", set to False when "partyB_type" = "specify"]
	eligibleCollateral EligibleCollateral (0..*) <"The eligible collateral as specified in relation to the pledgor/chargor/obligor(s) posting obligation. ISDA 2016 Credit Support Annex for Initial Margin, Eligible Credit Support (IM) Schedule.">
		[synonym ISDA_Create_1_0 value "partyA_eligible_currencies" set when "partyA_type" = "specify"]
		[synonym ISDA_Create_1_0 value "partyB_eligible_currencies" set when "partyB_type" = "specify"]
	excludedCollateral string (0..1) <"The excluded collateral as specified in relation to the pledgor/chargor/obligor(s) posting obligation. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ii)(B)(i)."> // This representation matches the current ISDA Create one, but should be aligned with the eligibleCollateral representation once that one is confirmed
		[synonym ISDA_Create_1_0 value "partyA_control_agreement_specify" set when "partyA_control_agreement" = "yey"]
		[synonym ISDA_Create_1_0 value "partyB_control_agreement_specify" set when "partyB_control_agreement" = "yey"]
		[synonym ISDA_Create_1_0 value "partyA_collateral_management_agreement_specify" set when "partyA_collateral_management_agreement" = "yey"]
		[synonym ISDA_Create_1_0 value "partyB_collateral_management_agreement_specify" set when "partyB_collateral_management_agreement" = "yey"]
	additionalLanguage string (0..1) <"The additional language that might be specified by the parties to the legal agreement.">
		[synonym ISDA_Create_1_0 value "partyA_additional_language"]
		[synonym ISDA_Create_1_0 value "partyB_additional_language"]
		[synonym ISDA_Create_1_0 value "additional_language"]

	condition AsPermitted: <"A data rule to enforce that the eligible collateral should be specified when the Control Agreement is a Credit Support Document with respect to the party(ies).">
		if asPermitted = True
		then eligibleCollateral is absent

	condition EligibleCollateral: <"A data rule to enforce that the eligible collateral shouldn't be specified when the Control Agreement isn't deemed a Credit Support Document with respect to the party(ies).">
		if asPermitted = False
		then eligibleCollateral exists

type ProcessAgent: <"A class to specify the Process Agent that might be appointed by the parties as part of a Credit Support Annex/Deed or Collateral Transfer Agreement.">
	//<"A class to specify the Process Agent that might be appointed by the parties to the agreement in accordance with the ISDA 2016 English Law CSA, paragraph 11(h). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (t): Process Agent.">
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "16"]

	partyElection ProcessAgentElection (2..2) <"The parties' Process Agent election.">

type ProcessAgentElection: <"A class to specify the parties' respective elections with respect to the Process Agent.">

	party string (1..1) <"The elective party.">
		[synonym AcadiaSoft_AM_1_0 value "party"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_process_agent" = "not_applicable", set to "partyA" when "partyA_process_agent" = "other"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_process_agent" = "not_applicable", set to "partyB" when "partyB_process_agent" = "other"]
	// TODO will need to streamline the parties here
	isApplicable boolean (1..1) <"The qualification of whether the Process Agent is applicable (True) or not applicable (False).">
		[synonym ISDA_Create_1_0 set to True when "partyA_process_agent" = "other", set to False when "partyA_process_agent" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_process_agent" = "other", set to False when "partyB_process_agent" = "not_applicable"]
	specification string (0..1) <"The Process Agent specification, when applicable.">
		[synonym ISDA_Create_1_0 value "partyA_specify" maps 2] // TODO: remove "maps 2" once migration complete
		[synonym ISDA_Create_1_0 value "partyB_specify" maps 2] // TODO: remove "maps 2" once migration complete

	condition Applicable: <"A data rule to enforce that the Process Agent must be specified when it is applicable.">
		if isApplicable = True
		then specification exists

	condition NotApplicable: <"A data rule to enforce that the Process Agent cannot be specified if deemed not applicable.">
		if isApplicable = False
		then specification is absent

type RecalculationOfValue: <"A class to specify terms for Recalculation of the Market Value of Posted Collateral when a dispute has been failed to be resolved by Resolution Time.">

	partyElection RecalculationOfValueElection (2..2)	<"The parties' Recalculation of Value terms.">

type RecalculationOfValueElection: <"A class to specify Recalculation of Value terms that will be applicable">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_recalculation_of_value" = "consultation_procedure", set to "partyA" when "partyA_recalculation_of_value" = "other_regulatory_CSA_procedure"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_recalculation_of_value" = "other_regulatory_CSA_procedure"]
		[synonym ISDA_Create_1_0 set to "partyA" when "recalculation_of_market_value" = "partyA_recalculation_of_market_value"]
		[synonym ISDA_Create_1_0 set to "partyB" when "recalculation_of_market_value" = "partyB_recalculation_of_market_value"]

	recalculationOfValueElection RecalculationOfValueElectionEnum (1..1) <"The procedure for Recalculation of Value.">
		[synonym ISDA_Create_1_0 value "partyA_recalculation_of_value"]
		[synonym ISDA_Create_1_0 value "partyB_recalculation_of_value"]
		[synonym ISDA_Create_1_0 value "partyA_recalculation_of_market_value"]
		[synonym ISDA_Create_1_0 value "partyB_recalculation_of_market_value"]

	recalculationOfValueTerms string (0..1) <"Additional Recalculation of Value terms when specified">
		[synonym ISDA_Create_1_0 value "partyA_recalculation_of_value_terms" set when "partyA_recalculation_of_value" = "other"]
		[synonym ISDA_Create_1_0 value "partyB_recalculation_of_value_terms" set when "partyB_recalculation_of_value" = "other"]
		[synonym ISDA_Create_1_0 value "partyA_recalculation_of_market_value_terms" set when "partyA_recalculation_of_market_value" = "other"]
		[synonym ISDA_Create_1_0 value "partyB_recalculation_of_market_value_terms" set when "partyB_recalculation_of_market_value" = "other"]

	condition recalculationOfValueTerms: <"A data rule to enforce that additional Recalculation of Value terms are only specified when applicable">
		if RecalculationOfValueElection exists
		then recalculationOfValueTerms is absent

type Regime: <"A class to specify one or more regimes that may be specified as relevant to a legal agreement. 2016/2018 ISDA Credit Support Annex for Initial Margin: Regime.">
	[synonym AcadiaSoft_AM_1_0 value "Regime"]

	applicableRegime ApplicableRegime (1..*) <"A class to specify the regime(s) that parties to a legal agreement, such as the ISDA 2016 and 2018 CSA for Initial Margin, might agree to apply to one or both parties when acting as collateral taker, and specific terms associated with that application.">
		[synonym ISDA_Create_1_0 value "canada", "sec", "cftc", "emir", "japan", "switzerland", "prudential", "australia", "hong_kong", "singapore" mapper "ApplicableRegime"]
	fallbackToMandatoryMethodDays number (0..1) <"The specification of the number of days after effective delivery of notice that Mandatory method fallback applies. Specification is only required when one or more Regimes have Fall Back to Mandatory Method elected as a SIMM exception.">
		[synonym ISDA_Create_1_0 value "fallback_to_mandatory_method_days" path "fallback_to_mandatory_method"]
	additionalRegime AdditionalRegime (0..*) <"The additional regulatory regime(s) that might be specified by the parties to a legal agreement. ISDA 2016 Credit Support Annex for Initial Margin paragraph 13, General Principles, (ll): The parties may from time to time agree in writing that other regimes also comprise `Regimes` and that the General Principles be adopted and/or amended to accommodate such additional Regimes.">
		[synonym ISDA_Create_1_0 value "additional_regimes"  mapper "AdditionalRegime"]

    //TODO - Data Rule required as per description below
//	condition FallbackToMandatoryMethodDays: <"A data rule to enforce that the specification of Fallback to Mandatory Method Days should only exist when one or more Regimes have Fallback to Mandatory Method elected as a SIMM exception.">
// 		if fallbackToMandatoryMethodDays exists
//		then applicableRegime -> regimeTerms -> simmException -> simmExceptionApplicable contains SimmExceptionApplicableEnum -> FallBackToMandatoryMethod

type RegimeTerms: <"A class that is used by the ApplicableRegime and the AdditionalRegime classes to specify the regulatory regime terms which are referred to as part of certain legal agreements, such as such as the ISDA 2016 and 2018 CSA for Initial Margin.">

	party string (1..1) <"The party for which the regime terms are being specified when acting as collateral taker.">
	isApplicable ExceptionEnum (0..1) <"The specification of whether the regime is elected as applicable to the party when acting as collateral taker.">
	asSpecified string (0..1) <"The bespoke party specific Regime term elections applicable when specified.">
	//TODO - Condition required that asSpecified only exists when isApplicable is Other
	simmException SimmException (0..1) <"The election for SIMM exception to the regulatory regime clause of the ISDA 2016 and 2018 CSA for Initial Margin as either a normalized value specified as part of an enumeration or a customized value specified of type string. ISDA 2016 Credit Support Annex for Initial Margin paragraph 13, Regime: SIMM Exception.">
	retrospectiveEffect RetrospectiveEffect (0..1) <"ISDA 2016 CSA for Initial Margin, paragraph 13 (b)(i): if `Retrospective Effect` is specified as applicable to a Regime (a `Retrospective Regime`) then all Covered Transactions (IM) under all other Regimes with an earlier Regime Effective Time will, to the extent that they would have been Covered Transactions (IM) under such Retrospective Regime had such Transactions been entered into at or after the Regime Effective Time of the Retrospective Regime, be deemed to be Covered Transactions (IM) for such Retrospective Regime.">
	//TODO - Condition required that retrospectiveEffect should exist for 2016 CSD and be absent for 2018 CSD

type RetrospectiveEffect: <"A class to specify the retrospective effect exception to the regulatory regime clause of Initial Margin documents as either a normalized value specified as part of an enumeration or a customized value specified of type string.">

	standardisedException ExceptionEnum (0..1) <"The Standard Initial Margin Model exception when specified by the party according to one of the enumerated values.">
	asSpecified string (0..1) <"The Standard Initial Margin Model exception when specified as a customized approach by the party.">
	// TODO condition asSpecified should only exist when standardisedException = Other


type ReturnAmount: <"A class to specify the application of Interest Amount with respect the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).">

	includesDefaultLanguage boolean (0..1) <"Default language is included when True, and excluded when False.">
		[synonym ISDA_Create_1_0 set to True when "return_amount" = "include", set to False when "return_amount" = "exclude", set to False when "return_amount" = "other"]
	customElection string (0..1) <"Custom election that might be specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "specify_return_amount"]
	condition CustomElection: <"A data rule to specify that when a custom election exists then default language should not be included.">
		if customElection exists then includesDefaultLanguage = False

type RightsEvents: <"A class to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred.">

	securityTakerRightsEvent SecuredPartyRightsEvent (1..1) <"The bespoke provisions that might be specified by the parties to the agreement applicable to a Security Taker Rights Event.">
		[synonym ISDA_Create_1_0 value "secured_party_rights_event"]
		[synonym ISDA_Create_1_0 value "security_taker_rights_event"]
		[synonym ISDA_Create_1_0 value "early_termination_date"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "h"]
	controlAgreementNecEvent ControlAgreementNecEvent (0..1) <"The bespoke provisions that might be specified by the parties to the agreement applicable to a Notice of Exclusive Control Event.">
		[synonym ISDA_Create_1_0 value "control_agreement_nec_event"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "i"]
	securityProviderRightsEvent SecurityProviderRightsEvent (1..1) <"The bespoke provisions that might be specified by the parties to the agreement applicable to a Security Provider Rights Event.">
		[synonym ISDA_Create_1_0 value "obligor_rights_event"]
		[synonym ISDA_Create_1_0 value "chargor_rights_event"]
		[synonym ISDA_Create_1_0 value "pledgor_rights_event"]
		[synonym ISDA_Create_1_0 value "security_provider_rights_event"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "j"]
	deliveryInLieuRight boolean (0..1) <"The specification of whether Delivery In Lieu language is applicable to the agreement (true) or not (false).">
		[synonym ISDA_Create_1_0 set to True when "delivery_in_lieu_right->right" = "applicable", set to False when "delivery_in_lieu_right->right" = "not_applicable"]
	// [documentReference ISDA CtaInitialMargin 2019 paragraph "13" section "l"]
	additionalRightsEvent AdditionalRightsEvent (0..1) <"The Additional Rights Event election.">
		[synonym ISDA_Create_1_0 value "chargor_additional_rights_event"]
		[synonym ISDA_Create_1_0 value "obligor_additional_rights_event"]
		[synonym ISDA_Create_1_0 value "pledgor_additional_rights_event"]

type SecuredPartyRightsEvent: <"A class to specify Secured Party Rights Event language">

	securedPartyRightsEventElection SecuredPartyRightsEventElection (0..2)

	earlyTerminationDateOptionalLanguage boolean (1..1) <"A boolean attribute to specify whether Failure to Pay Early Termination language is included (True) or excluded (False) from the agreement.">
		[synonym ISDA_Create_1_0 set to True when "early_termination_date_optional_language" = "include", set to False when "early_termination_date_optional_language" = "exclude"]
		[synonym ISDA_Create_1_0 set to True when "paid_in_full_language" = "include", set to False when "paid_in_full_language" = "exclude"]


	failureToPayEarlyTermination boolean (0..1) <"A boolean attribute to specify whether Failure to Pay Early Termination language in the agreement is deemed applicable or not.">
		[synonym ISDA_Create_1_0 set to True when "failure_to_pay_early_termination_is_applicable" = "applicable",
									set to False when "failure_to_pay_early_termination_is_applicable" = "not_applicable"]

	condition FailureToPayLanguage: <"A data rule to enforce that the applicability of Failure to Pay language is only applied when Early Termination language is included.">
		if earlyTerminationDateOptionalLanguage = False
		then failureToPayEarlyTermination is absent

type SecuredPartyRightsEventElection: <"A class to specify party specific Secured Party Rights Event language">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_secured_party_rights_event" = "applicable", set to "partyA" when "partyA_secured_party_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_secured_party_rights_event" = "applicable", set to "partyB" when "partyB_secured_party_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_security_taker_rights_event" = "applicable", set to "partyA" when "partyA_security_taker_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_security_taker_rights_event" = "applicable", set to "partyB" when "partyB_security_taker_rights_event" = "not_applicable"]

	rightsEvent boolean (1..1) <"A boolean attribute to specify whether a Secured Party Rights Event will only occur upon the occurrence of one or more of the event specified in a Control Agreement">
		[synonym ISDA_Create_1_0 set to True when "partyA_secured_party_rights_event" = "applicable", set to False when "partyA_secured_party_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_secured_party_rights_event" = "applicable", set to False when "partyB_secured_party_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyA_security_taker_rights_event" = "applicable", set to False when "partyA_security_taker_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_security_taker_rights_event" = "applicable", set to False when "partyB_security_taker_rights_event" = "not_applicable"]

type SecurityAgreementElections: <"The set of elections which specify a Security Agremeent">

	pledgedAccount Account (0..1) <"The pledged account associated with the agreement">
		[synonym ISDA_Create_1_0 value "pledged_account_number"]
	enforcementEvent EnforcementEvent (0..1) <"Enforcement Events specific to the agreement">
		[synonym ISDA_Create_1_0 value "enforcement_event"]
		[synonym ISDA_Create_1_0 value "early_termination_date"]
	deliveryInLieuRight boolean (0..1) <"Delivery In Lieu rights">
		[synonym ISDA_Create_1_0 set to True when "delivery_in_lieu_right->right" = "applicable", set to False when "delivery_in_lieu_right->right" = "not_applicable"]
	fullDischarge boolean (0..1) <"Full Discharge condition">
		[synonym ISDA_Create_1_0 set to True when "security_provider_full_discharge_condition->is_applicable" = "applicable",
									set to False when "security_provider_full_discharge_condition->is_applicable" = "not_applicable"]
	appropriatedCollateralValuation AppropriatedCollateralValuation (0..1) <"The election for the Valuation of Appropriate Collateral.">
		[synonym ISDA_Create_1_0 value "valuation_of_appropriated_collateral"]
	processAgent ProcessAgent (0..1) <"The Process Agent that might be appointed by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "process_agent"]
	jurisdictionRelatedTerms JurisdictionRelatedTerms (0..1) <"The jurisdiction specific terms">
	additionalAmendments string (0..1) <"Any additional amendments that might be specified by the parties to the agreement.">
		[synonym ISDA_Create_1_0 value "specify" path "amendments" maps 2 set when "amendments->is_applicable" = "applicable"] // TODO: remove "maps 2" once migration complete
	additionalBespokeTerms string (0..1) <"Any additional terms that might be specified applicable.">
		[synonym ISDA_Create_1_0 value "specify" path "additional_terms" set when "additional_terms->is_applicable" = "applicable"]
		[synonym ISDA_Create_1_0 value "specify" path "bespoke_provisions" set when "bespoke_provisions->is_applicable" = "applicable"]
	executionTerms ExecutionTerms (0..1) <"The location and language of execution to determine duty to be paid.">
		[synonym ISDA_Create_1_0 value "execution_language"]

type SecurityProviderRightsEvent: <"A class to specify the Pledgor/Obligor/Chargor Rights Event election. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (j): Chargor Rights Event. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (j): Obligor Rights Event. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (j): Pledgor Rights Event.">

	partyElection SecurityProviderRightsEventElection (0..2)
	includeCoolingOffLanguage boolean (1..1) <"The Pledgor/Obligor/Chargor Rights Event election includes cooling off language when the attribute is set of True.">
		[synonym ISDA_Create_1_0 set to True when "cooling_off_language" = "include", set to False when "cooling_off_language" = "not_specified", set to False when "cooling_off_language" = "other"]
		[synonym ISDA_Create_1_0 set to True when "cooling_off_period_condition_is_applicable" = "applicable", set to False when "cooling_off_period_condition_is_applicable" = "not_applicable"]
	fullDischarge boolean (0..1) <"If specified as applicable here, a Pledgor/Obligor/Chargor Rights Event will not occur unless the Pledgor/Obligor/Chargor (A) has provided a statement to the Secured Party in respect of such Early 											Termination Date">
		[synonym ISDA_Create_1_0 set to True when "chargor_full_discharge_condition_is_applicable" = "applicable", set to False when "chargor_full_discharge_condition_is_applicable" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "pledgor_full_discharge_condition_is_applicable" = "applicable", set to False when "pledgor_full_discharge_condition_is_applicable" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "obligor_full_discharge_condition_is_applicable" = "applicable", set to False when "obligor_full_discharge_condition_is_applicable" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "security_provider_full_discharge_condition_is_applicable" = "applicable",
								set to False when "security_provider_full_discharge_condition_is_applicable" = "not_applicable"]
	automaticSetOff boolean (0..1) <"The Automatic Set-Off provision applies when the value is set to True. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (l): Modification to Obligor’s Rights and Remedies.">
		[synonym ISDA_Create_1_0 set to True when "automatic_setoff->right" = "applicable", set to False when "automatic_setoff->right" = "not_applicable"]

	customElection string (0..1) <"A custom Pledgor/Obligor/Chargor Rights Event election might be specified by the parties.">
		[synonym ISDA_Create_1_0 value "specify"]

	condition RightsEvent_includeCoolingOffLanguage: <"A data rule to enforce that, when the Rights Event election includes cooling off language, no custom election should be specified.">
		if includeCoolingOffLanguage = True
		then customElection is absent

	condition RightsEvent_customElection: <"A data rule to enforce that, when the Rights Event is specified through a custom election, no standard cooling off language should be specified.">
		if customElection exists
		then includeCoolingOffLanguage = False

type SecurityProviderRightsEventElection: <"A class to specify party specific Secured Party Rights Event language.">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_chargor_rights_event" = "applicable", set to "partyA" when "partyA_chargor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_chargor_rights_event" = "applicable", set to "partyB" when "partyB_chargor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_pledgor_rights_event" = "applicable", set to "partyA" when "partyA_pledgor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_pledgor_rights_event" = "applicable", set to "partyB" when "partyB_pledgor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_obligor_rights_event" = "applicable", set to "partyA" when "partyA_obligor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_obligor_rights_event" = "applicable", set to "partyB" when "partyB_obligor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_security_provider_rights_event" = "applicable", set to "partyA" when "partyA_security_provider_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_security_provider_rights_event" = "applicable", set to "partyB" when "partyB_security_provider_rights_event" = "not_applicable"]

	rightsEvent boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_chargor_rights_event" = "applicable", set to False when "partyA_chargor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_chargor_rights_event" = "applicable", set to False when "partyB_chargor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyA_pledgor_rights_event" = "applicable", set to False when "partyA_pledgor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_pledgor_rights_event" = "applicable", set to False when "partyB_pledgor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyA_obligor_rights_event" = "applicable", set to False when "partyA_obligor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_obligor_rights_event" = "applicable", set to False when "partyB_obligor_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyA_security_provider_rights_event" = "applicable", set to False when "partyA_security_provider_rights_event" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_security_provider_rights_event" = "applicable", set to False when "partyB_security_provider_rights_event" = "not_applicable"]

type SensitivityMethodologies: <"A class to specificy methodologies to compute sensitivities specific to the agreement.">

	sensitivityToEquity SensitivityMethodology (1..1) <"The methodology to compute sensitivities to equity indices, funds and ETFs for the purpose of Initial Margin agreements.">
		[synonym ISDA_Create_1_0 value "sensitivities_to_equity_indices_funds_etfs"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (g)(ii)(A)"]
	sensitivityToCommodity SensitivityMethodology (1..1) <"The methodology to compute sensitivities to commodity indices for the purpose of Initial Margin agreements.">
		[synonym ISDA_Create_1_0 value "sensitivities_to_commodity_indices"]
	// [documentReference Euroclear CtaInitialMargin 2019 paragraph "13" section "General Principles (g)(ii)(B)"]

type SensitivityMethodology: <"A class to specify the methodology according to which sensitivities to (i) equity indices, funds and ETFs, and (ii) commodity indices are computed. This specification is done either through a normalized election as part of the specifiedMethodology, or through a custom election via the customMethodology attribute. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (gg)(2).">

	specifiedMethodology SensitivitiesEnum (0..1) <"The methodology according to which sensitivities will be computed, when specified through a normalized election.">
		[synonym ISDA_Create_1_0 value "sensitivities_equity_indices_funds_etfs", "sensitivities_commodity_indices"]
	customMethodology string (0..1) <"The methodology according to which sensitivities will be computed, when specified through a custom election.">
		[synonym ISDA_Create_1_0 value "sensitivities_equity_indices_funds_etfs_specify", "sensitivities_commodity_indices_specify"]
	condition: one-of

type SimmCalculationCurrency: <"A class to specify the SIMM Calculation Currency elections by each party to the agreement.">
<<<<<<< HEAD
	
=======

>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	partyElection CalculationCurrencyElection (2..2) <"The parties' SIMM Calculation Currency election.">

type SimmException: <"A class to specify the SIMM exception to the regulatory regime clause of the ISDA 2016 and 2018 CSA for Initial Margin as either a normalized value specified as part of an enumeration or a customized value specified of type string. ISDA 2016 Credit Support Annex for Initial Margin paragraph 13, Regime: SIMM Exception.">

	standardisedException ExceptionEnum (0..1) <"The Standard Initial Margin Model exception when specified by the party according to one of the enumerated values.">
		[synonym AcadiaSoft_AM_1_0 set to ExceptionEnum -> NotApplicable when "simmException" = "False"]
	simmExceptionApplicable SimmExceptionApplicableEnum (0..1) <"The Standard Initial Margin model exception approach applicable when specified by the party according to one of the enumerated values.">
	// TODO condition that SimmExceptionApplicableEnum should only exist if SimmExceptionEnum = Applicable
	asSpecified string (0..1) <"The Standard Initial Margin Model exception when specified as a customized approach by the party.">
	// TODO condition asSpecified exists if something OtherMethods are specified

type SimmVersion: <"A class to specify the ISDA SIMM version that applies to the ISDA 2018 CSA for Initial Margin. According to the ISDA 2018 CSA for Initial Margin, Paragraph 13, General Principles (ee) (1) provisions, the SIMM version is either not specified, or references a version used by one of the parties to the agreement.">

	isSpecified boolean (0..1) <"A boolean attribute to determine whether the SIMM version is specified for the purpose of the legal agreement.">
		[synonym ISDA_Create_1_0 set to True when "is_specified" = "specified", set to False when "is_specified" = "not_specified"]
	partyVersion string (0..1) <"The party which the specified SIMM version applies to.">
		[metadata reference]
		[synonym ISDA_Create_1_0 set to "PartyA" when "party_A_or_party_B_version" = "partyA", set to "PartyB" when "party_A_or_party_B_version" = "partyB"]
	//	TODO - ISDA Create export has a blank value type referencing party in 2018 CSD Eng Law schema.  Feedback to ISDA
	asSpecified string (0..1) <"The SIMM version exception when specified as a customized approach by the party.">
		[synonym ISDA_Create_1_0 value "specify" set when "is_specified" = "other"]


	condition VersionNotSpecified: <"A data rule to enforce that the version attribute should be absent when the SIMM version is stated as not specified for the CSA.">
		if isSpecified = False
		then partyVersion is absent

	condition VersionSpecified: <"A data rule to enforce that the version attribute should be specified when the SIMM version is stated as specified for the CSA.">
		if isSpecified = True
		then partyVersion exists

type SubstitutedRegime: <"A class to specify each party's election with respect to the Substituted Regimes that will be applicable...">

	partyElection SubstitutedRegimeElection (2..2) <"The parties' Substituted Regime election.">

type SubstitutedRegimeElection: <"A class to specify the Substituted Regimes that will be deemed applicable...">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_emir" = "applicable", set to "partyA" when "partyA_emir" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_emir" = "applicable", set to "partyB" when "partyB_emir" = "not_applicable"]
	emir boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_emir" = "applicable", set to False when "partyA_emir" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_emir" = "applicable", set to False when "partyB_emir" = "not_applicable"]
	prudential boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_prudential" = "applicable", set to False when "partyA_prudential" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_prudential" = "applicable", set to False when "partyB_prudential" = "not_applicable"]
	cftc boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_cftc" = "applicable", set to False when "partyA_cftc" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_cftc" = "applicable", set to False when "partyB_cftc" = "not_applicable"]
	sec boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_sec" = "applicable", set to False when "partyA_sec" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_sec" = "applicable", set to False when "partyB_sec" = "not_applicable"]
	canada boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_canada" = "applicable", set to False when "partyA_canada" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_canada" = "applicable", set to False when "partyB_canada" = "not_applicable"]
	switzerland boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_switzerland" = "applicable", set to False when "partyA_switzerland" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_switzerland" = "applicable", set to False when "partyB_switzerland" = "not_applicable"]
	japan boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_japan" = "applicable", set to False when "partyA_japan" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_japan" = "applicable", set to False when "partyB_japan" = "not_applicable"]
	australia boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_australia" = "applicable", set to False when "partyA_australia" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_australia" = "applicable", set to False when "partyB_australia" = "not_applicable"]
	hong_kong boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_hong_kong" = "applicable", set to False when "partyA_hong_kong" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_hong_kong" = "applicable", set to False when "partyB_hong_kong" = "not_applicable"]
	singapore boolean (1..1)
		[synonym ISDA_Create_1_0 set to True when "partyA_singapore" = "applicable", set to False when "partyA_singapore" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "partyB_singapore" = "applicable", set to False when "partyB_singapore" = "not_applicable"]

type Substitution: <"A class to specify the conditions under which the Security Provider can substitute posted collateral.">

	needsConsent boolean (1..1) <"The election as to whether the Pledgor/Obligor/Chargor must obtain the Secured Party’s consent for any collateral substitution. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii): Consent. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (f)(ii): Consent.">
		[synonym ISDA_Create_1_0  set to True when "is_applicable" = "standard", set to False when "is_applicable" = "other"]
		[synonym ISDA_Create_1_0  set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
	specificConsentLanguage string (0..1) <"Specific consent language might be specified by the parties.">
		[synonym ISDA_Create_1_0 value "specify"]

type TerminationCurrencyAmendment: <"A class to specify the Amendment to Termination Currency elections by the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (t): Amendment to Termination Currency.">

	isApplicable boolean (1..1) <"The qualification of whether the Amendment to Termination Currency is deemed applicable by the parties (True) or not (False).">
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
		[synonym ISDA_Create_1_0 set to True when "amendment_to_termination_currency_is" = "applicable", set to False when "amendment_to_termination_currency_is" = "not_applicable" ]
	effectiveDate AmendmentEffectiveDate (0..1) <"The effective date of the Amendment to Termination Currency. This date can be specified as either an actual date, a specific date (e.g. the annex date) or as a custom provision.">
	partyElection TerminationCurrencyElection (0..3) <"The parties' Amendment Currency election.">

	condition Applicablity: <"The Amendment to Termination Currency elections only apply when the Amendment to Termination Currency is deemed applicable by the parties.">
		if isApplicable = False
		then ( effectiveDate
		and partyElection) is absent // TODO - Logic to be confirmed by testing NotApplicable

type TerminationCurrencyElection: <"A class to specify the Amendment to Termination Currency election by the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (t) (A) & (B).">

	party string (1..1) <"The elective party.">
		[synonym ISDA_Create_1_0 set to "partyA" when "partyA_amendment_to_termination_currency" = "specify", set to "partyA" when "partyA_amendment_to_termination_currency" = "in_schedule"]
		[synonym ISDA_Create_1_0 set to "partyB" when "partyB_amendment_to_termination_currency" = "specify", set to "partyB" when "partyB_amendment_to_termination_currency" = "in_schedule"]
		[synonym ISDA_Create_1_0 set to "partyA,partyB" when "two_affected_parties" = "specify", set to "partyA,partyB" when "two_affected_parties" = "in_schedule"]
	isSpecified boolean (1..1) <"The qualification of whether the Termination Currency is specified in this document (True) or in an Eligible Support Credit Support (IM) Schedule (False)">
		[synonym ISDA_Create_1_0 set to True when "partyA_amendment_to_termination_currency" = "specify", set to False when "partyA_amendment_to_termination_currency" = "in_schedule"]
		[synonym ISDA_Create_1_0 set to True when "partyB_amendment_to_termination_currency" = "specify", set to False when "partyB_amendment_to_termination_currency" = "in_schedule"]
		[synonym ISDA_Create_1_0 set to True when "two_affected_parties" = "specify", set to False when "two_affected_parties" = "in_schedule"]
	currency string (1..1) <"The Termination Currency associated with the party that referenced as part of this class. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.">
		[metadata scheme]
		[synonym ISDA_Create_1_0 value "partyA_termination_currency"]
		[synonym ISDA_Create_1_0 value "partyB_termination_currency"]
		[synonym ISDA_Create_1_0 value "partyA_currency"]
		[synonym ISDA_Create_1_0 value "partyB_currency"]
		[synonym ISDA_Create_1_0 value "two_affected_parties_currency"]
		[synonym ISDA_Create_1_0 value "both_parties_termination_currency"]

	condition CurrencyElection: <"A Termination Currency election should only exist when required by the affected parties election">
		if isSpecified = False then currency is absent

type Threshold: <"A class to specify the unsecured credit exposure that each party to the agreement is prepared to accept before asking for collateral. This threshold is specified either as an amount or as a custom election. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(A): Threshold. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(A): Threshold. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(A): Threshold.">

	partyElection ElectiveAmountElection (2..2) <"The parties' Threshold election.">

type TransactionConfirmation: <"See existing Contract type">
// TODO - Next step to move Contract from Contractual Product to here.  Will require significant refactoring of model.

type UmbrellaAgreement: <"A class to specify a set of legal entities which are part of a legal agreement beyond the two contracting parties to that agreement. This data representation reflects the ISDA Create representation.">

	isApplicable boolean (1..1) <"The determination of whether Umbrella Agreement terms are Applicable (True), or Not Applicable (False)">
		[synonym ISDA_Create_1_0 set to True when "is_applicable" = "applicable", set to False when "is_applicable" = "not_applicable"]
	language string (0..1) <"The language associated with the umbrella agreement, and which applies to all the parties to the umbrella agreement.">
		[synonym ISDA_Create_1_0 value "language" maps 2] // TODO: remove "maps 2" once migration complete
	parties UmbrellaAgreementEntity (0..*) <"Underlying principals to the umbrella agreement.">
		[synonym ISDA_Create_1_0 value "principal_identification_schedule" mapper "UmbrellaAgreementEntity"]
<<<<<<< HEAD
	
=======

>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	condition UmbrellaAgreementExists: <"Umbrella Agreement language and parties should not exist when Umbrella Agreement terms are Not Applicable.">
		if isApplicable = True
		then (language and parties) exists

type UmbrellaAgreementEntity extends LegalEntity: <"A class to specify the legal entities that are part of the umbrella agreement.">
	terms string (0..1) <"The terms that might be associated with each party to the umbrella agreement.">

// Agreement Validation

func SaIsdaBankCustodian2019NewYorkLaw:
	// [validation agreement]
	inputs: agreementTerms AgreementTerms (1..1)
	output: is_agreement boolean (1..1)
<<<<<<< HEAD
	
=======

>>>>>>> a53aaa1d7a58040d4b1017416403adb1f0c589f7
	assign-output is_agreement:
		agreementTerms -> relatedAgreements -> legalAgreement -> agreementType -> name = LegalAgreementNameEnum->CollateralTransferAgreement //The agreement is a CTA
		and agreementTerms -> relatedAgreements -> legalAgreement -> agreementType -> publisher = LegalAgreementPublisherEnum->ISDA //published by ISDA
		and agreementTerms -> relatedAgreements -> legalAgreement -> agreementType -> governingLaw = GoverningLawEnum->USNY //under New York Law
		and agreementTerms -> relatedAgreements -> legalAgreement -> agreementType -> vintage = "2019" //with vintage 2019
		and agreementTerms -> relatedAgreements -> legalAgreement -> agreementDate exists //then the CTA should have an agreement date specified
		and agreementTerms -> agreement -> securityAgreementElections -> pledgedAccount is absent //there should not be a PledgedAccount
		and agreementTerms -> agreement -> securityAgreementElections -> enforcementEvent is absent //there should not be EnforcementEvent terms specified
		and agreementTerms -> agreement -> securityAgreementElections -> deliveryInLieuRight is absent //there should not be Delivery in Lieu Right terms specified
		and agreementTerms -> agreement -> securityAgreementElections -> fullDischarge is absent //there should not be Full Discharge terms specified
		and agreementTerms -> agreement -> securityAgreementElections -> appropriatedCollateralValuation is absent //there should not be any Valuation of Appropriated Collateral terms specified
		and agreementTerms -> agreement -> securityAgreementElections -> processAgent exists //there should be Process Agent terms specified
		and agreementTerms -> agreement -> securityAgreementElections -> jurisdictionRelatedTerms -> japaneseSecuritiesProvisions exists //there should be Japanese Securities Provisions specified
		and agreementTerms -> agreement -> securityAgreementElections -> jurisdictionRelatedTerms -> exclusiveJurisdiction exists //there should be Exclusive Jurisdiction terms specified
		and agreementTerms -> agreement -> securityAgreementElections -> jurisdictionRelatedTerms -> juryWaiver exists //there should be Jury Waiver terms specified
