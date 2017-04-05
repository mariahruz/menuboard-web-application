var request = require("request");
var expect = require("chai").expect;
var baseUrl = "http://localhost:8080";
var util = require("util");

describe("get products", function() {
    it("gets products from api", function(done) {
        request.get({url: baseUrl+'/products'},
            function(error, response, body) {
                expect(response.statusCode).to.equal(200);
                console.log(body);
                done();
            });
    });
});