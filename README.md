# Number converter
Simple REST application that converts decimal numbers into hexadecimals or roman numerals.
To run application read "Quick start.md".

## API 
### endpoints:
    /convert 
        Requires request body with fields: 
            1. "value" - integer
            2. "type" - string (enum: HEXADECIMAL, ROMAN_NUMERAL)
        Responses:
            200 - if the type of conversion is HEXADECMIAL and given values is non negative 
                  or if the type is ROMAN_NUMERAL and value is in range [0, 3999]
            400 - in any other case
