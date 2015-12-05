package com.catalina.lakon

import grails.converters.JSON

class RelasiEntitasController {

    def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET"]
	def RelasiEntitasService
	
	def list() {
		render RelasiEntitasService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!RelasiEntitasService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!RelasiEntitasService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		RelasiEntitas relasiEntitas = RelasiEntitas.findById(id.toLong())

		render relasiEntitas as JSON

	}
}