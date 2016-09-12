package com.example.haseyuuki.fujitsuchizaihase;

/**
 * Created by haseyuuki on 2016/09/03.
 */
public enum Countries {

    Afghanistan,
    Albania,
    Algeria,
    Andorra,
    Angola,
    AntiguaAndBarbuda,
    Argentina,
    Armenia,
    Australia,
    Austria,
    Azerbaijan,
    Bahamas,
    Bahrain,
    Bangladesh,
    Barbados,
    Belarus,
    Belgium,
    Belize,
    Benin,
    Bhutan,
    Bolivia,
    BosniaAndHerzegovina,
    Botswana,
    Brazil,
    BruneiDarussalam,
    Bulgaria,
    BurkinaFaso,
    Burundi,
    Cambodia,
    Cameroon,
    Canada,
    CapeVerde,
    CentralAfricanRepublic,
    Chad,
    Chile,
    China,
    Colombia,
    Comoros,
    Congo,
    CookIslands,
    CostaRica,
    CoteDIvoire,
    Croatia,
    Cuba,
    Cyprus,
    CzechRepublic,
    DemocraticRepublicOfTheCongo,
    Denmark,
    Djibouti,
    Dominica,
    DominicanRepublic,
    Ecuador,
    Egypt,
    ElSalvador,
    EquatorialGuinea,
    Eritrea,
    Estonia,
    Ethiopia,
    Fiji,
    Finland,
    France,
    Gabon,
    Gambia,
    Georgia,
    Germany,
    Ghana,
    Greece,
    Grenada,
    Guatemala,
    Guinea,
    GuineaBissau,
    Guyana,
    Haiti,
    Honduras,
    Hungary,
    Iceland,
    India,
    Indonesia,
    Iran,
    Iraq,
    Ireland,
    Israel,
    Italy,
    Jamaica,
    Japan,
    Jordan,
    Kazakhstan,
    Kenya,
    Kiribati,
    Kuwait,
    Kyrgyzstan,
    LaoPeoplesDemocraticRepublic,
    Latvia,
    Lebanon,
    Lesotho,
    Liberia,
    Libya,
    Liechtenstein,
    Lithuania,
    Luxembourg,
    Madagascar,
    Malawi,
    Malaysia,
    Maldives,
    Mali,
    Malta,
    MarshallIslands,
    Mauritania,
    Mauritius,
    Mexico,
    Micronesia,
    Monaco,
    Mongolia,
    Montenegro,
    Morocco,
    Mozambique,
    Myanmar,
    Namibia,
    Nauru,
    Nepal,
    Netherlands,
    NewZealand,
    Nicaragua,
    Niger,
    Nigeria,
    Niue,
    Norway,
    Oman,
    Pakistan,
    Palau,
    Panama,
    PapuaNewGuinea,
    Paraguay,
    Peru,
    Philippines,
    Poland,
    Portugal,
    Qatar,
    RepublicOfKorea,
    RepublicOfKosovo,
    RepublicOfMoldova,
    Romania,
    RussianFederation,
    Rwanda,
    SaintKittsAndNevis,
    SaintLucia,
    SaintVincentAndtheGrenadines,
    Samoa,
    SanMarino,
    SaoTomeAndPrincipe,
    SaudiArabia,
    Senegal,
    Serbia,
    Seychelles,
    SierraLeone,
    Singapore,
    Slovakia,
    Slovenia,
    SolomonIslands,
    Somalia,
    SouthAfrica,
    SouthSudan,
    Spain,
    SriLanka,
    Sudan,
    Suriname,
    Swaziland,
    Sweden,
    Switzerland,
    Syria,
    Tajikistan,
    Thailand,
    TheFormarYugoslavRepublicOfMacedonia,
    TimorLeste,
    Togo,
    Tonga,
    TrinidadAndTobago,
    Tunisia,
    Turkey,
    Turkmenistan,
    Tuvalu,
    Uganda,
    Ukraine,
    UnitedArabEmirates,
    UnitedKingdom,
    UnitedOfRepublicOfTanzania,
    UnitedStates,
    Uruguay,
    Uzbekistan,
    Vanuatu,
    Vatican,
    Venezuela,
    VietNam,
    Yemen,
    Zambia,
    Zimbabwe;

    private static final Countries defValue = Japan; //デフォルトを「Japan」に設定
    //文字列と照合して Enum 型で返す
    public static final Countries toEnum(String str) {
        for (Countries e : Countries.values()) {
            if (str.equalsIgnoreCase(e.toString())) {
                return e;
            }
        }
        return defValue;
    }
}
