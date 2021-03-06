"use strict";
var validate = (function () {
  var refVal = [];
  return function validate(
    data,
    dataPath,
    parentData,
    parentDataProperty,
    rootData
  ) {
    "use strict";
    validate.errors = null;
    return true;
  };
})();
validate.schema = {
  Release: "00503",
  DocumentType: 945,
  TransactionSet: [
    {
      ID: "ST",
      Min: 0,
    },
    {
      ID: "W06",
    },
    {
      ID: "N1Loop1",
      Max: 10,
      Loop: [
        {
          ID: "N1",
        },
        {
          ID: "N2",
          Min: 0,
        },
        {
          ID: "N3",
          Min: 0,
          Max: 2,
        },
        {
          ID: "N4",
          Min: 0,
        },
        {
          ID: "PER",
          Min: 0,
          Max: 5,
        },
      ],
    },
    {
      ID: "N9",
      Min: 0,
      Max: 10,
    },
    {
      ID: "G61",
      Min: 0,
      Max: 3,
    },
    {
      ID: "G62",
      Min: 0,
      Max: 5,
    },
    {
      ID: "NTE",
      Min: 0,
      Max: 20,
    },
    {
      ID: "W27",
      Min: 0,
    },
    {
      ID: "W6",
      Min: 0,
    },
    {
      ID: "W28",
      Min: 0,
    },
    {
      ID: "W10",
      Min: 0,
      Max: 10,
    },
    {
      ID: "G72",
      Min: 0,
      Max: 5,
    },
    {
      ID: "TD1",
      Min: 0,
      Max: 5,
    },
    {
      ID: "LMLoop1",
      Min: 0,
      Max: 10,
      Loop: [
        {
          ID: "LM",
        },
        {
          ID: "LQ",
          Max: 100,
        },
      ],
    },
    {
      ID: "LXLoop1",
      Min: 0,
      Max: "unbounded",
      Loop: [
        {
          ID: "LX",
        },
        {
          ID: "MAN",
          Min: 0,
          Max: "unbounded",
        },
        {
          ID: "PAL",
          Min: 0,
        },
        {
          ID: "N9",
          Min: 0,
          Max: 5,
        },
        {
          ID: "W12Loop1",
          Min: 0,
          Max: "unbounded",
          Loop: [
            {
              ID: "W12",
            },
            {
              ID: "G69",
              Min: 0,
              Max: 5,
            },
            {
              ID: "N9",
              Min: 0,
              Max: 200,
            },
            {
              ID: "G62",
              Min: 0,
              Max: 10,
            },
            {
              ID: "QTY",
              Min: 0,
              Max: 10,
            },
            {
              ID: "MEA",
              Min: 0,
              Max: 5,
            },
            {
              ID: "AMT",
              Min: 0,
            },
            {
              ID: "R4",
              Min: 0,
              Max: 5,
            },
            {
              ID: "W27",
              Min: 0,
            },
            {
              ID: "N1Loop2",
              Min: 0,
              Max: "unbounded",
              Loop: [
                {
                  ID: "N1",
                },
                {
                  ID: "N2",
                  Min: 0,
                },
                {
                  ID: "N3",
                  Min: 0,
                },
                {
                  ID: "N4",
                  Min: 0,
                },
                {
                  ID: "PER",
                  Min: 0,
                },
              ],
            },
            {
              ID: "G72",
              Min: 0,
              Max: 5,
            },
            {
              ID: "LMLoop2",
              Min: 0,
              Max: 10,
              Loop: [
                {
                  ID: "LM",
                },
                {
                  ID: "LQ",
                  Max: 100,
                },
              ],
            },
            {
              ID: "LSLoop1",
              Min: 0,
              Loop: [
                {
                  ID: "LS",
                  Min: 1,
                  Max: 1,
                },
                {
                  ID: "LXLoop2",
                  Min: 0,
                  Max: "unbounded",
                  Loop: [
                    {
                      ID: "LX",
                    },
                    {
                      ID: "N9",
                      Min: 0,
                      Max: "unbounded",
                    },
                    {
                      ID: "G62",
                      Min: 0,
                      Max: 10,
                    },
                    {
                      ID: "N1",
                      Min: 0,
                    },
                    {
                      ID: "LMLoop3",
                      Min: 0,
                      Max: 10,
                      Loop: [
                        {
                          ID: "LM",
                        },
                        {
                          ID: "LQ",
                          Max: 100,
                        },
                      ],
                    },
                  ],
                },
                {
                  ID: "LE",
                  Min: 1,
                  Max: 1,
                },
              ],
            },
            {
              ID: "FA1Loop1",
              Min: 0,
              Max: "unbounded",
              Loop: [
                {
                  ID: "FA1",
                },
                {
                  ID: "FA2",
                  Max: "unbounded",
                },
              ],
            },
          ],
        },
      ],
    },
    {
      ID: "W03",
      Min: 0,
    },
    {
      ID: "SE",
      Min: 0,
    },
  ],
};
validate.errors = null;
module.exports = validate;
