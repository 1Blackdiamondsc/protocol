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
  Release: "00602",
  DocumentType: 890,
  TransactionSet: [
    {
      ID: "ST",
      Min: 0,
    },
    {
      ID: "CTH",
    },
    {
      ID: "CUR",
      Min: 0,
    },
    {
      ID: "DTM",
      Min: 0,
      Max: 10,
    },
    {
      ID: "MTX",
      Min: 0,
    },
    {
      ID: "REF",
      Min: 0,
      Max: "unbounded",
    },
    {
      ID: "SAC",
      Min: 0,
      Max: "unbounded",
    },
    {
      ID: "NM1Loop1",
      Min: 0,
      Max: "unbounded",
      Loop: [
        {
          ID: "NM1",
        },
        {
          ID: "NX1",
          Min: 0,
        },
        {
          ID: "PPR",
          Min: 0,
          Max: "unbounded",
        },
        {
          ID: "N2",
          Min: 0,
          Max: 2,
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
          Max: "unbounded",
        },
        {
          ID: "N1Loop1",
          Min: 0,
          Max: "unbounded",
          Loop: [
            {
              ID: "N1",
            },
            {
              ID: "N2",
              Min: 0,
              Max: 2,
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
              Max: "unbounded",
            },
          ],
        },
      ],
    },
    {
      ID: "AMTLoop1",
      Min: 0,
      Max: "unbounded",
      Loop: [
        {
          ID: "AMT",
        },
        {
          ID: "MTX",
          Min: 0,
        },
      ],
    },
    {
      ID: "QTYLoop1",
      Min: 0,
      Max: "unbounded",
      Loop: [
        {
          ID: "QTY",
        },
        {
          ID: "MTX",
          Min: 0,
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
          ID: "N1Loop2",
          Min: 0,
          Max: 3,
          Loop: [
            {
              ID: "N1",
            },
            {
              ID: "DTM",
              Max: 2,
            },
            {
              ID: "TBP",
              Min: 0,
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
      ID: "CPLLoop1",
      Min: 0,
      Max: "unbounded",
      Loop: [
        {
          ID: "CPL",
        },
        {
          ID: "REF",
          Min: 0,
          Max: "unbounded",
        },
        {
          ID: "PPR",
          Min: 0,
          Max: "unbounded",
        },
        {
          ID: "MTX",
          Min: 0,
        },
        {
          ID: "DTMLoop1",
          Min: 0,
          Max: "unbounded",
          Loop: [
            {
              ID: "DTM",
            },
            {
              ID: "TBP",
              Min: 0,
            },
            {
              ID: "N1",
              Min: 0,
              Max: "unbounded",
            },
          ],
        },
        {
          ID: "AMTLoop2",
          Min: 0,
          Max: "unbounded",
          Loop: [
            {
              ID: "AMT",
            },
            {
              ID: "MEA",
              Min: 0,
              Max: 2,
            },
            {
              ID: "TBP",
              Min: 0,
            },
          ],
        },
        {
          ID: "LS",
          Min: 0,
        },
        {
          ID: "N1Loop3",
          Min: 0,
          Max: "unbounded",
          Loop: [
            {
              ID: "N1",
            },
            {
              ID: "QTY",
              Min: 0,
            },
            {
              ID: "AMT",
              Min: 0,
            },
            {
              ID: "MTX",
              Min: 0,
            },
            {
              ID: "PSG",
              Min: 0,
              Max: "unbounded",
            },
            {
              ID: "CPI",
              Min: 0,
            },
            {
              ID: "SEFLoop1",
              Min: 0,
              Loop: [
                {
                  ID: "SEF",
                },
                {
                  ID: "DTMLoop2",
                  Min: 0,
                  Max: "unbounded",
                  Loop: [
                    {
                      ID: "DTM",
                    },
                    {
                      ID: "MTX",
                      Min: 0,
                    },
                  ],
                },
              ],
            },
          ],
        },
        {
          ID: "LE",
          Min: 0,
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
              ID: "MTX",
              Min: 0,
            },
            {
              ID: "FX2Loop1",
              Min: 0,
              Max: "unbounded",
              Loop: [
                {
                  ID: "FX2",
                },
                {
                  ID: "AMT",
                  Min: 0,
                },
                {
                  ID: "QTY",
                  Min: 0,
                },
                {
                  ID: "FX6",
                  Min: 0,
                  Max: "unbounded",
                },
                {
                  ID: "FX7",
                  Min: 0,
                  Max: "unbounded",
                },
              ],
            },
            {
              ID: "FX3Loop1",
              Min: 0,
              Max: "unbounded",
              Loop: [
                {
                  ID: "FX3",
                },
                {
                  ID: "FU3",
                  Min: 0,
                },
                {
                  ID: "FU4",
                  Min: 0,
                },
                {
                  ID: "FU5",
                  Min: 0,
                },
                {
                  ID: "AMT",
                  Min: 0,
                },
                {
                  ID: "QTY",
                  Min: 0,
                },
              ],
            },
            {
              ID: "FU1Loop1",
              Min: 0,
              Max: "unbounded",
              Loop: [
                {
                  ID: "FU1",
                },
                {
                  ID: "FU2",
                },
              ],
            },
            {
              ID: "FX4Loop1",
              Min: 0,
              Max: "unbounded",
              Loop: [
                {
                  ID: "FX4",
                },
                {
                  ID: "REF",
                  Min: 0,
                  Max: 2,
                },
                {
                  ID: "N1",
                  Max: "unbounded",
                },
                {
                  ID: "DTM",
                  Min: 0,
                  Max: "unbounded",
                },
                {
                  ID: "ECS",
                  Min: 0,
                },
              ],
            },
            {
              ID: "FX5Loop1",
              Min: 0,
              Max: "unbounded",
              Loop: [
                {
                  ID: "FX5",
                },
                {
                  ID: "N1",
                  Max: "unbounded",
                },
                {
                  ID: "DTM",
                  Min: 0,
                  Max: "unbounded",
                },
                {
                  ID: "QTY",
                  Min: 0,
                },
                {
                  ID: "ECS",
                  Min: 0,
                },
                {
                  ID: "FX4Loop2",
                  Min: 0,
                  Max: "unbounded",
                  Loop: [
                    {
                      ID: "FX4",
                    },
                    {
                      ID: "REF",
                      Min: 0,
                      Max: 2,
                    },
                  ],
                },
              ],
            },
          ],
        },
      ],
    },
    {
      ID: "SE",
      Min: 0,
    },
  ],
};
validate.errors = null;
module.exports = validate;
