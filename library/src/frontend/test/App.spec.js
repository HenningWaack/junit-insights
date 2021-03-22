import { shallowMount } from "@vue/test-utils"
import App from "@/App.vue"

var dummyReport = {
    "reportTitle": "JUnit Insights Report 25.10.2018 11:39:08",
    "created": "Oct 25, 2018 11:39:08 AM",
    "springContextsCreated": 2,
    "testClasses": [
        {
            "name": "CalculatorTest",
            "firstTimestamp": 1540460343587,
            "methods": [
                {
                    "name": "basicArithmetic()",
                    "firstTimestamp": 1540460343587,
                    "before": 2,
                    "exec": 4,
                    "after": 1,
                    "successful": true
                }
            ],
            "beforeAll": 19,
            "before": 2, "exec": 4, "after": 1, "afterAll": 4, "between": 0, "spring": 0,
            "activeSpringProfiles": ["default"]
        },
        {
            "name": "NewTest",
            "firstTimestamp": 1540460343625,
            "methods": [{
                "name": "basicTest()",
                "firstTimestamp": 1540460343625,
                "before": 62,
                "exec": 0,
                "after": 2,
                "successful": true
            },
            {
                "name": "basicTest3()",
                "firstTimestamp": 1540460347002,
                "before": 1,
                "exec": 0,
                "after": 1,
                "successful": true
            },
            {
                "name": "delayTest()",
                "firstTimestamp": 1540460347007,
                "before": 1,
                "exec": 301,
                "after": 2, "successful": true
            }
            ],
            "beforeAll": 31,
            "before": 64,
            "exec": 301,
            "after": 5,
            "afterAll": 0,
            "between": 16,
            "spring": 3269
        },
        {
            "name": "AnotherHelloControllerTest",
            "firstTimestamp": 1540460347319,
            "methods": [
                {
                    "name": "getAnotherHello()",
                    "firstTimestamp": 1540460347319,
                    "before": 1,
                    "exec": 55,
                    "after": 2, "successful": true
                },
                {
                    "name": "getHello()",
                    "firstTimestamp": 1540460348212,
                    "before": 1, "exec": 3, "after": 1, "successful": true
                }], "beforeAll": 20, "before": 2, "exec": 58, "after": 3, "afterAll": 0, "between": 1, "spring": 814
        },
        {
            "name": "HelloControllerTest",
            "firstTimestamp": 1540460348219,
            "methods": [
                {
                    "name": "Second test method",
                    "firstTimestamp": 1540460348219,
                    "before": 1,
                    "exec": 3,
                    "after": 1,
                    "successful": true
                },
                {
                    "name": "First test method",
                    "firstTimestamp": 1540460348241,
                    "before": 1,
                    "exec": 5,
                    "after": 2,
                    "successful": true
                }
            ],
            "beforeAll": 14,
            "before": 2,
            "exec": 8,
            "after": 3,
            "afterAll": 1,
            "between": 3,
            "spring": 0
        }
    ]
}

describe("App", () => {
    it("starts", () => {
        var wrapper = shallowMount(App, {
            propsData: {
                report: dummyReport
            }
        })
    })
})
