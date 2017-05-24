#!/usr/bin/env python3
import json, csv

lines_name = ["1", "2", "3", "3b", "4", "5", "6", "7", "7b", "8", "9", "10", "11", "12", "13", "14"]
# lines_name = ["3", "3b"]

folder_save = "lignes/json"

data_dic = {}
lineid_name = {}

data_dic['stops'] = {}

def getFolderData(line):
    return "lignes/RATP_GTFS_METRO_{}".format(line)

def saveData(line_name, data):
    graph_file = open("{}/graph-metro-{}.json".format(folder_save, line_name), 'w')
    graph_file.write(data)

def readStops(name, data):
    for index, line in enumerate(data):
        if index != 0:
            lineid_name[line[0]] = line[2]

            if line[2] not in data_dic['stops']:
                data_dic['stops'][line[2]] = {}
                data_dic['stops'][line[2]]['links'] = []

            if "location" not in data_dic['stops'][line[2]]:
                data_dic['stops'][line[2]]['location'] = {
                    "lat": float(line[4]),
                    "long": float(line[5])
                }


            if "lines" not in data_dic['stops'][line[2]]:
                data_dic['stops'][line[2]]['lines'] = []

            station_name = "M" + name
            if station_name not in data_dic['stops'][line[2]]['lines']:
                data_dic['stops'][line[2]]['lines'] += [station_name]

def getStationNameFromId(id):
    return lineid_name[id]

def addLink(stop, stopLinked):
    if stopLinked not in data_dic['stops'][stop['station_name']]['links']:
        data_dic['stops'][stop['station_name']]['links'] += [stopLinked]

def readStopTime(name, data):
    trips = []
    stops = []
    lastId = None
    for index, stop in enumerate(data):
        if index != 0:
            if lastId == stop[0] or lastId == None:
                stops += [{
                    "line": "M"+name,
                    "station_name": getStationNameFromId(stop[3])
                }]
            else:
                if stops not in trips:
                    trips += [stops]
                stops = []
            lastId = stop[0]

    for trip in trips:
        for index, stop in enumerate(trip):
            if index > 0:
                addLink(stop, trip[index-1])
            if index < len(trip) - 1:
                addLink(stop, trip[index+1])


def readFiles():
    for name in lines_name:
        with open("{}/stops.txt".format(getFolderData(name)), 'r', encoding='utf-8') as line_stops:
            readStops(name, csv.reader(line_stops))
        with open("{}/stop_times.txt".format(getFolderData(name)), 'r', encoding='utf-8') as stop_time:
            readStopTime(name, csv.reader(stop_time))

readFiles()
data = open('data.json', 'w')
json.dump(data_dic, data, indent=2, ensure_ascii=False)
