Ext.define('Ung.store.Countries', {
    extend: 'Ext.data.Store',
    alias: 'store.countries',
    storeId: 'countries',
    data: [
        { code: 'XU', name: 'Unknown'.t() },
        { code: 'XL', name: 'Local'.t() },
        { code: 'AF', name: 'Afghanistan'.t() },
        { code: 'AX', name: 'Aland Islands'.t() },
        { code: 'AL', name: 'Albania'.t() },
        { code: 'DZ', name: 'Algeria'.t() },
        { code: 'AS', name: 'American Samoa'.t() },
        { code: 'AD', name: 'Andorra'.t() },
        { code: 'AO', name: 'Angola'.t() },
        { code: 'AI', name: 'Anguilla'.t() },
        { code: 'AQ', name: 'Antarctica'.t() },
        { code: 'AG', name: 'Antigua and Barbuda'.t() },
        { code: 'AR', name: 'Argentina'.t() },
        { code: 'AM', name: 'Armenia'.t() },
        { code: 'AW', name: 'Aruba'.t() },
        { code: 'AU', name: 'Australia'.t() },
        { code: 'AT', name: 'Austria'.t() },
        { code: 'AZ', name: 'Azerbaijan'.t() },
        { code: 'BS', name: 'Bahamas'.t() },
        { code: 'BH', name: 'Bahrain'.t() },
        { code: 'BD', name: 'Bangladesh'.t() },
        { code: 'BB', name: 'Barbados'.t() },
        { code: 'BY', name: 'Belarus'.t() },
        { code: 'BE', name: 'Belgium'.t() },
        { code: 'BZ', name: 'Belize'.t() },
        { code: 'BJ', name: 'Benin'.t() },
        { code: 'BM', name: 'Bermuda'.t() },
        { code: 'BT', name: 'Bhutan'.t() },
        { code: 'BO', name: 'Bolivia, Plurinational State of'.t() },
        { code: 'BQ', name: 'Bonaire, Sint Eustatius and Saba'.t() },
        { code: 'BA', name: 'Bosnia and Herzegovina'.t() },
        { code: 'BW', name: 'Botswana'.t() },
        { code: 'BV', name: 'Bouvet Island'.t() },
        { code: 'BR', name: 'Brazil'.t() },
        { code: 'IO', name: 'British Indian Ocean Territory'.t() },
        { code: 'BN', name: 'Brunei Darussalam'.t() },
        { code: 'BG', name: 'Bulgaria'.t() },
        { code: 'BF', name: 'Burkina Faso'.t() },
        { code: 'BI', name: 'Burundi'.t() },
        { code: 'KH', name: 'Cambodia'.t() },
        { code: 'CM', name: 'Cameroon'.t() },
        { code: 'CA', name: 'Canada'.t() },
        { code: 'CV', name: 'Cape Verde'.t() },
        { code: 'KY', name: 'Cayman Islands'.t() },
        { code: 'CF', name: 'Central African Republic'.t() },
        { code: 'TD', name: 'Chad'.t() },
        { code: 'CL', name: 'Chile'.t() },
        { code: 'CN', name: 'China'.t() },
        { code: 'CX', name: 'Christmas Island'.t() },
        { code: 'CC', name: 'Cocos (Keeling) Islands'.t() },
        { code: 'CO', name: 'Colombia'.t() },
        { code: 'KM', name: 'Comoros'.t() },
        { code: 'CG', name: 'Congo'.t() },
        { code: 'CD', name: 'Congo, the Democratic Republic of the'.t() },
        { code: 'CK', name: 'Cook Islands'.t() },
        { code: 'CR', name: 'Costa Rica'.t() },
        { code: 'CI', name: 'Cote d\'Ivoire'.t() },
        { code: 'HR', name: 'Croatia'.t() },
        { code: 'CU', name: 'Cuba'.t() },
        { code: 'CW', name: 'Curacao'.t() },
        { code: 'CY', name: 'Cyprus'.t() },
        { code: 'CZ', name: 'Czech Republic'.t() },
        { code: 'DK', name: 'Denmark'.t() },
        { code: 'DJ', name: 'Djibouti'.t() },
        { code: 'DM', name: 'Dominica'.t() },
        { code: 'DO', name: 'Dominican Republic'.t() },
        { code: 'EC', name: 'Ecuador'.t() },
        { code: 'EG', name: 'Egypt'.t() },
        { code: 'SV', name: 'El Salvador'.t() },
        { code: 'GQ', name: 'Equatorial Guinea'.t() },
        { code: 'ER', name: 'Eritrea'.t() },
        { code: 'EE', name: 'Estonia'.t() },
        { code: 'ET', name: 'Ethiopia'.t() },
        { code: 'FK', name: 'Falkland Islands (Malvinas)'.t() },
        { code: 'FO', name: 'Faroe Islands'.t() },
        { code: 'FJ', name: 'Fiji'.t() },
        { code: 'FI', name: 'Finland'.t() },
        { code: 'FR', name: 'France'.t() },
        { code: 'GF', name: 'French Guiana'.t() },
        { code: 'PF', name: 'French Polynesia'.t() },
        { code: 'TF', name: 'French Southern Territories'.t() },
        { code: 'GA', name: 'Gabon'.t() },
        { code: 'GM', name: 'Gambia'.t() },
        { code: 'GE', name: 'Georgia'.t() },
        { code: 'DE', name: 'Germany'.t() },
        { code: 'GH', name: 'Ghana'.t() },
        { code: 'GI', name: 'Gibraltar'.t() },
        { code: 'GR', name: 'Greece'.t() },
        { code: 'GL', name: 'Greenland'.t() },
        { code: 'GD', name: 'Grenada'.t() },
        { code: 'GP', name: 'Guadeloupe'.t() },
        { code: 'GU', name: 'Guam'.t() },
        { code: 'GT', name: 'Guatemala'.t() },
        { code: 'GG', name: 'Guernsey'.t() },
        { code: 'GN', name: 'Guinea'.t() },
        { code: 'GW', name: 'Guinea-Bissau'.t() },
        { code: 'GY', name: 'Guyana'.t() },
        { code: 'HT', name: 'Haiti'.t() },
        { code: 'HM', name: 'Heard Island and McDonald Islands'.t() },
        { code: 'VA', name: 'Holy See (Vatican City State)'.t() },
        { code: 'HN', name: 'Honduras'.t() },
        { code: 'HK', name: 'Hong Kong'.t() },
        { code: 'HU', name: 'Hungary'.t() },
        { code: 'IS', name: 'Iceland'.t() },
        { code: 'IN', name: 'India'.t() },
        { code: 'ID', name: 'Indonesia'.t() },
        { code: 'IR', name: 'Iran, Islamic Republic of'.t() },
        { code: 'IQ', name: 'Iraq'.t() },
        { code: 'IE', name: 'Ireland'.t() },
        { code: 'IM', name: 'Isle of Man'.t() },
        { code: 'IL', name: 'Israel'.t() },
        { code: 'IT', name: 'Italy'.t() },
        { code: 'JM', name: 'Jamaica'.t() },
        { code: 'JP', name: 'Japan'.t() },
        { code: 'JE', name: 'Jersey'.t() },
        { code: 'JO', name: 'Jordan'.t() },
        { code: 'KZ', name: 'Kazakhstan'.t() },
        { code: 'KE', name: 'Kenya'.t() },
        { code: 'KI', name: 'Kiribati'.t() },
        { code: 'KP', name: 'Korea, Democratic People\'s Republic of'.t() },
        { code: 'KR', name: 'Korea, Republic of'.t() },
        { code: 'KW', name: 'Kuwait'.t() },
        { code: 'KG', name: 'Kyrgyzstan'.t() },
        { code: 'LA', name: 'Lao People\'s Democratic Republic'.t() },
        { code: 'LV', name: 'Latvia'.t() },
        { code: 'LB', name: 'Lebanon'.t() },
        { code: 'LS', name: 'Lesotho'.t() },
        { code: 'LR', name: 'Liberia'.t() },
        { code: 'LY', name: 'Libya'.t() },
        { code: 'LI', name: 'Liechtenstein'.t() },
        { code: 'LT', name: 'Lithuania'.t() },
        { code: 'LU', name: 'Luxembourg'.t() },
        { code: 'MO', name: 'Macao'.t() },
        { code: 'MK', name: 'Macedonia, the Former Yugoslav Republic of'.t() },
        { code: 'MG', name: 'Madagascar'.t() },
        { code: 'MW', name: 'Malawi'.t() },
        { code: 'MY', name: 'Malaysia'.t() },
        { code: 'MV', name: 'Maldives'.t() },
        { code: 'ML', name: 'Mali'.t() },
        { code: 'MT', name: 'Malta'.t() },
        { code: 'MH', name: 'Marshall Islands'.t() },
        { code: 'MQ', name: 'Martinique'.t() },
        { code: 'MR', name: 'Mauritania'.t() },
        { code: 'MU', name: 'Mauritius'.t() },
        { code: 'YT', name: 'Mayotte'.t() },
        { code: 'MX', name: 'Mexico'.t() },
        { code: 'FM', name: 'Micronesia, Federated States of'.t() },
        { code: 'MD', name: 'Moldova, Republic of'.t() },
        { code: 'MC', name: 'Monaco'.t() },
        { code: 'MN', name: 'Mongolia'.t() },
        { code: 'ME', name: 'Montenegro'.t() },
        { code: 'MS', name: 'Montserrat'.t() },
        { code: 'MA', name: 'Morocco'.t() },
        { code: 'MZ', name: 'Mozambique'.t() },
        { code: 'MM', name: 'Myanmar'.t() },
        { code: 'NA', name: 'Namibia'.t() },
        { code: 'NR', name: 'Nauru'.t() },
        { code: 'NP', name: 'Nepal'.t() },
        { code: 'NL', name: 'Netherlands'.t() },
        { code: 'NC', name: 'New Caledonia'.t() },
        { code: 'NZ', name: 'New Zealand'.t() },
        { code: 'NI', name: 'Nicaragua'.t() },
        { code: 'NE', name: 'Niger'.t() },
        { code: 'NG', name: 'Nigeria'.t() },
        { code: 'NU', name: 'Niue'.t() },
        { code: 'NF', name: 'Norfolk Island'.t() },
        { code: 'MP', name: 'Northern Mariana Islands'.t() },
        { code: 'NO', name: 'Norway'.t() },
        { code: 'OM', name: 'Oman'.t() },
        { code: 'PK', name: 'Pakistan'.t() },
        { code: 'PW', name: 'Palau'.t() },
        { code: 'PS', name: 'Palestine, State of'.t() },
        { code: 'PA', name: 'Panama'.t() },
        { code: 'PG', name: 'Papua New Guinea'.t() },
        { code: 'PY', name: 'Paraguay'.t() },
        { code: 'PE', name: 'Peru'.t() },
        { code: 'PH', name: 'Philippines'.t() },
        { code: 'PN', name: 'Pitcairn'.t() },
        { code: 'PL', name: 'Poland'.t() },
        { code: 'PT', name: 'Portugal'.t() },
        { code: 'PR', name: 'Puerto Rico'.t() },
        { code: 'QA', name: 'Qatar'.t() },
        { code: 'RE', name: 'Reunion'.t() },
        { code: 'RO', name: 'Romania'.t() },
        { code: 'RU', name: 'Russian Federation'.t() },
        { code: 'RW', name: 'Rwanda'.t() },
        { code: 'BL', name: 'Saint Barthelemy'.t() },
        { code: 'SH', name: 'Saint Helena, Ascension and Tristan da Cunha'.t() },
        { code: 'KN', name: 'Saint Kitts and Nevis'.t() },
        { code: 'LC', name: 'Saint Lucia'.t() },
        { code: 'MF', name: 'Saint Martin (French part)'.t() },
        { code: 'PM', name: 'Saint Pierre and Miquelon'.t() },
        { code: 'VC', name: 'Saint Vincent and the Grenadines'.t() },
        { code: 'WS', name: 'Samoa'.t() },
        { code: 'SM', name: 'San Marino'.t() },
        { code: 'ST', name: 'Sao Tome and Principe'.t() },
        { code: 'SA', name: 'Saudi Arabia'.t() },
        { code: 'SN', name: 'Senegal'.t() },
        { code: 'RS', name: 'Serbia'.t() },
        { code: 'SC', name: 'Seychelles'.t() },
        { code: 'SL', name: 'Sierra Leone'.t() },
        { code: 'SG', name: 'Singapore'.t() },
        { code: 'SX', name: 'Sint Maarten (Dutch part)'.t() },
        { code: 'SK', name: 'Slovakia'.t() },
        { code: 'SI', name: 'Slovenia'.t() },
        { code: 'SB', name: 'Solomon Islands'.t() },
        { code: 'SO', name: 'Somalia'.t() },
        { code: 'ZA', name: 'South Africa'.t() },
        { code: 'GS', name: 'South Georgia and the South Sandwich Islands'.t() },
        { code: 'SS', name: 'South Sudan'.t() },
        { code: 'ES', name: 'Spain'.t() },
        { code: 'LK', name: 'Sri Lanka'.t() },
        { code: 'SD', name: 'Sudan'.t() },
        { code: 'SR', name: 'Suriname'.t() },
        { code: 'SJ', name: 'Svalbard and Jan Mayen'.t() },
        { code: 'SZ', name: 'Swaziland'.t() },
        { code: 'SE', name: 'Sweden'.t() },
        { code: 'CH', name: 'Switzerland'.t() },
        { code: 'SY', name: 'Syrian Arab Republic'.t() },
        { code: 'TW', name: 'Taiwan, Province of China'.t() },
        { code: 'TJ', name: 'Tajikistan'.t() },
        { code: 'TZ', name: 'Tanzania, United Republic of'.t() },
        { code: 'TH', name: 'Thailand'.t() },
        { code: 'TL', name: 'Timor-Leste'.t() },
        { code: 'TG', name: 'Togo'.t() },
        { code: 'TK', name: 'Tokelau'.t() },
        { code: 'TO', name: 'Tonga'.t() },
        { code: 'TT', name: 'Trinidad and Tobago'.t() },
        { code: 'TN', name: 'Tunisia'.t() },
        { code: 'TR', name: 'Turkey'.t() },
        { code: 'TM', name: 'Turkmenistan'.t() },
        { code: 'TC', name: 'Turks and Caicos Islands'.t() },
        { code: 'TV', name: 'Tuvalu'.t() },
        { code: 'UG', name: 'Uganda'.t() },
        { code: 'UA', name: 'Ukraine'.t() },
        { code: 'AE', name: 'United Arab Emirates'.t() },
        { code: 'GB', name: 'United Kingdom'.t() },
        { code: 'US', name: 'United States'.t() },
        { code: 'UM', name: 'United States Minor Outlying Islands'.t() },
        { code: 'UY', name: 'Uruguay'.t() },
        { code: 'UZ', name: 'Uzbekistan'.t() },
        { code: 'VU', name: 'Vanuatu'.t() },
        { code: 'VE', name: 'Venezuela, Bolivarian Republic of'.t() },
        { code: 'VN', name: 'Viet Nam'.t() },
        { code: 'VG', name: 'Virgin Islands, British'.t() },
        { code: 'VI', name: 'Virgin Islands, U.S.'.t() },
        { code: 'WF', name: 'Wallis and Futuna'.t() },
        { code: 'EH', name: 'Western Sahara'.t() },
        { code: 'YE', name: 'Yemen'.t() },
        { code: 'ZM', name: 'Zambia'.t() },
        { code: 'ZW', name: 'Zimbabwe'.t() }
    ]
});
